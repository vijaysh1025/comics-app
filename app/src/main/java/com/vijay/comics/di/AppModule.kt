package com.vijay.comics.di

import android.content.Context
import com.vijay.comics.features.home.repo.ComicsRepo
import com.vijay.comics.features.home.repo.ComicsRepoImpl
import com.vijay.comics.features.home.repo.remote.ComicsService
import com.vijay.comics.retrofit.ApiKeyInterceptor
import com.vijay.comics.retrofit.CallAdapterFactory
import com.vijay.comics.retrofit.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideComicsRepository(
        comicsService: ComicsService,
        dispatcher: CoroutineDispatcher
    ) : ComicsRepo {
        return ComicsRepoImpl(comicsService, dispatcher)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO


}

@Module
@InstallIn(SingletonComponent::class)
object AppServiceModule {

    /**
     * Provide Comic Reftrofit service
     */
    @Singleton
    @Provides
    fun provideComicService(
        okHttpClient: OkHttpClient,
        callAdapterFactory: CallAdapter.Factory,
    ): ComicsService {
        return Retrofit.Builder()
            .baseUrl(ComicsService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClient).build()
            .create(ComicsService::class.java)
    }

    /**
     * Provide call adaptor Factory to convert Call to Result
     */
    @Singleton
    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        CallAdapterFactory()

    /**
     * Provide OkHttpClient with required interceptors
     * ApiKeyInterceptor - Add api_key param to request
     * LoggingInterceptor - Logs network request and response
     */
    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(context))
            .addInterceptor(LoggingInterceptor(ComicsService.Name))
            .build()
    }

}

