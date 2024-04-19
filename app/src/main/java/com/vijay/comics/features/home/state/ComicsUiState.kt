package com.vijay.comics.features.home.state

import com.vijay.comics.features.home.model.ResultsItem

sealed interface ComicsUiState {

    /**
     * Load successful remote fetched data
     */
    class Success(val list: List<ResultsItem>):ComicsUiState

    /**
     * Failed to load data
     */
    class Failure(val message: String):ComicsUiState

    /**
     * Empty response
     */
    object Empty : ComicsUiState

    /**
     * Waiting for data load
     */
    object Loading: ComicsUiState
}