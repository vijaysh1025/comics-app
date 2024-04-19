package com.vijay.comics.features.home.repo

import com.vijay.comics.features.home.model.ComicInfoResponse
import com.vijay.comics.features.home.model.ComicsResponse
import com.vijay.comics.features.home.model.ResultsItem
import com.vijay.comics.features.home.repo.remote.ComicsService
import com.vijay.comics.retrofit.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ComicsRepoImpl(
    private val remoteDataSource:ComicsService,
    private val dispatcher: CoroutineDispatcher
) : ComicsRepo {

    /**
     * Keep a local cache of response so we don't make unecessary remote requests
     */
    private var cachedResponse:ComicsResponse? = null

    /**
     * Fetch list of comics to load
     */
    override fun loadComics(remoteReload:Boolean) : Flow<Result<ComicsResponse>> {
        return flow {
            when {
                // If not user triggered reload and local cache exists
                !remoteReload && cachedResponse != null -> emit(Result.Success(cachedResponse, true))

                // no cache or user triggered reload
                else -> {
                    val response = remoteDataSource.getComics()

                    when{
                        // if remote is success, cache response
                        response is Result.Success -> {
                            cachedResponse = response.data
                            emit(response)
                        }
                        // if remote is a failure, use existing cached response
                        cachedResponse != null -> {
                            emit(Result.Success(cachedResponse, true))
                        }
                        // if no cached response and remote is failure
                        else -> emit(response)
                    }
                }
            }
        }.flowOn(dispatcher)
    }

    override fun loadComic(id: Int): Flow<Result<ResultsItem>> {
        return flow {
            cachedResponse?.data?.results?.find { it?.id == id }?.let {
                emit(Result.Success(it))
            } ?: emit(Result.Failure(0))
        }
    }
}