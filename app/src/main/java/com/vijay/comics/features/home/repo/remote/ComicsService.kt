package com.vijay.comics.features.home.repo.remote

import com.vijay.comics.features.home.model.ComicInfoResponse
import com.vijay.comics.features.home.model.ComicsResponse
import com.vijay.comics.retrofit.Result
import retrofit2.http.GET

interface ComicsService {

    @GET("comics")
    suspend fun getComics(): Result<ComicsResponse>

    @GET("comics/{}")
    suspend fun getComicInfo(): Result<ComicInfoResponse>

    companion object{
        const val BASE_URL: String = "https://gateway.marvel.com/v1/public/"
        val Name:String = ComicsService::class.java.simpleName
    }
}