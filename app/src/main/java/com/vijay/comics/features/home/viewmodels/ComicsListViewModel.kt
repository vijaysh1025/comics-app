package com.vijay.comics.features.home.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vijay.comics.features.home.model.ResultsItem
import com.vijay.comics.features.home.repo.ComicsRepo
import com.vijay.comics.features.home.state.ComicsUiState
import com.vijay.comics.retrofit.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsListViewModel @Inject constructor(val repo: ComicsRepo, val dispatcher: CoroutineDispatcher) : ViewModel() {

    /**
     * UI state to determine which screens to show
     */
    private val _uiState = MutableStateFlow<ComicsUiState>(ComicsUiState.Empty)
    val uiState: StateFlow<ComicsUiState> = _uiState

    private val _currentItem = MutableStateFlow(ResultsItem(id = 11))
    val currentItem: StateFlow<ResultsItem> = _currentItem
    /**
     * Fetch comics from repo and map result to proper UI state
     */
    fun loadComicsList(userReload: Boolean = false) {
        _uiState.value = ComicsUiState.Loading
        viewModelScope.launch(dispatcher) {
            repo.loadComics(userReload)
                .collect {
                    _uiState.value = when (it) {
                        // Show failure state in UI
                        is Result.Failure -> ComicsUiState.Failure(it.rawResponse ?: "Failure")
                        is Result.NetworkError -> ComicsUiState.Failure(
                            it.error.message ?: "Network Failure"
                        )
                        is Result.Success -> {
                            val list = it.data?.data?.results?.filterNotNull()
                            list?.forEach {item ->
                                item.thumbnail?.url = item.thumbnail?.path?.replace("http", "https")?.plus(".")?.plus(item.thumbnail.extension) ?: ""
                            }
                            if(list.isNullOrEmpty()) {
                                // Empty UI state
                                ComicsUiState.Empty
                            } else {
                                // Show list of comics
                                ComicsUiState.Success(list)
                            }
                        }
                    }
                }
        }
    }

    fun loadComicInfo(id:Int) {
        viewModelScope.launch(dispatcher) {
            repo.loadComic(id)
                .collect {
                    if(it is Result.Success) {
                        it.data?.let {item ->
                            _currentItem.value = item
                        }
                    }
                }
        }
    }

}