package com.vijay.comics.features.home.viewmodels

import app.cash.turbine.test
import com.vijay.comics.features.home.model.ComicsResponse
import com.vijay.comics.features.home.repo.ComicsRepo
import com.vijay.comics.features.home.repo.getListResponse
import com.vijay.comics.features.home.state.ComicsUiState
import com.vijay.comics.retrofit.Result
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ComicsViewModelTest {

    private lateinit var repo:ComicsRepo

    @Before
    fun setUp() {
        repo = mockk<ComicsRepo>()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `successful list load test`() = runTest {
        val repoFlow:Flow<Result<ComicsResponse>> = flow {
            emit(Result.Success(getListResponse()))
        }
        every { repo.loadComics() } returns repoFlow
        val viewModel = ComicsListViewModel(repo, UnconfinedTestDispatcher(testScheduler))

        repoFlow.test {
            viewModel.loadComicsList()
            awaitItem()
            println("list -> ${viewModel.uiState.value}")
            assertEquals((viewModel.uiState.value as ComicsUiState.Success).list.isNotEmpty(), true)
            awaitComplete()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `empty list load test`() = runTest {
        val repoFlow:Flow<Result<ComicsResponse>> = flow {
            emit(Result.Success(ComicsResponse()))
        }

        every { repo.loadComics() } returns repoFlow
        val viewModel = ComicsListViewModel(repo, UnconfinedTestDispatcher(testScheduler))

        repoFlow.test {
            viewModel.loadComicsList()
            awaitItem()
            println("empty -> ${viewModel.uiState.value}")
            assertEquals(viewModel.uiState.value, ComicsUiState.Empty)
            awaitComplete()
        }
    }

    @Test
    fun `failure load test`() = runTest {
        val repoFlow:Flow<Result<ComicsResponse>> = flow {
            emit(Result.Failure(403, ))
        }

        every { repo.loadComics() } returns repoFlow
        val viewModel = ComicsListViewModel(repo, UnconfinedTestDispatcher(testScheduler))

        repoFlow.test {
            viewModel.loadComicsList()
            awaitItem()
            println("failure -> ${viewModel.uiState.value}")
            assertEquals(viewModel.uiState.value is ComicsUiState.Failure, true)
            awaitComplete()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `network failure load test`() = runTest {
        val repoFlow:Flow<Result<ComicsResponse>> = flow {
            emit(Result.NetworkError(Exception() ))
        }

        every { repo.loadComics() } returns repoFlow
        val viewModel = ComicsListViewModel(repo, UnconfinedTestDispatcher(testScheduler))

        repoFlow.test {
            viewModel.loadComicsList()
            awaitItem()
            println("network -> ${viewModel.uiState.value}")
            assertEquals(viewModel.uiState.value is ComicsUiState.Failure, true)
            awaitComplete()
        }
    }


}