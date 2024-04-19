package com.vijay.comics.features.home.repo

import com.vijay.comics.features.home.model.ComicInfoResponse
import com.vijay.comics.features.home.model.ComicsResponse
import com.vijay.comics.features.home.model.ResultsItem
import com.vijay.comics.retrofit.Result
import kotlinx.coroutines.flow.Flow

interface ComicsRepo {

    fun loadComics(remoteReload:Boolean = false) : Flow<Result<ComicsResponse>>

    fun loadComic(id:Int) : Flow<Result<ResultsItem>>
}