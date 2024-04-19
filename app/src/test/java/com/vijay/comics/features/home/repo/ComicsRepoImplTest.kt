package com.vijay.comics.features.home.repo

import app.cash.turbine.test
import com.vijay.comics.features.home.repo.remote.ComicsService
import com.vijay.comics.retrofit.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class ComicsRepoImplTest {

    private val service = mockk<ComicsService>()


    @Test
    fun `load comics success`() = runTest {
        val repository = ComicsRepoImpl(service, Dispatchers.Default)
        coEvery { service.getComics() } returns Result.Success(getListResponse())

        // Test that on fresh launch response is from network
        repository.loadComics().test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Success(getListResponse()), result)
            awaitComplete()
        }

        // Test that on non-user triggered reload is from local cache
        repository.loadComics().test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Success(getListResponse(), true), result)
            awaitComplete()
        }

        // Test that on user triggered reload is from network
        repository.loadComics(true).test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Success(getListResponse()), result)
            awaitComplete()
        }
    }

    @Test
    fun `load comics failure with no cache`() = runTest {
        val repository = ComicsRepoImpl(service, Dispatchers.Default)

        // Remote service failure
        coEvery { service.getComics() } returns Result.Failure(403)
        repository.loadComics().test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Failure(403), result)
            awaitComplete()
        }

        // Remote service failure - network error
        val networkError = Result.NetworkError(Exception("Failed to parse"))
        coEvery { service.getComics() } returns networkError
        repository.loadComics().test {
            val result = awaitItem()
            println(result)
            assertEquals(networkError, result)
            awaitComplete()
        }
    }

    @Test
    fun `load comics failure with existing cache`() = runTest {
        val repository = ComicsRepoImpl(service, Dispatchers.Default)

        // Test that on fresh launch response is from network
        coEvery { service.getComics() } returns Result.Success(getListResponse())
        repository.loadComics().test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Success(getListResponse()), result)
            awaitComplete()
        }

        // Remote service failure -> Cache should be loaded
        coEvery { service.getComics() } returns Result.Failure(403)
        repository.loadComics(true).test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Success(getListResponse(), true), result)
            awaitComplete()
        }

        // Remote service failure -> Cache should be loaded
        coEvery { service.getComics() } returns Result.NetworkError(Exception("Failure"))
        repository.loadComics(true).test {
            val result = awaitItem()
            println(result)
            assertEquals(Result.Success(getListResponse(), true), result)
            awaitComplete()
        }
    }

}
