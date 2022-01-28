package com.veda.virginmoney.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.veda.virginmoney.data.remote.ApiData
import com.veda.virginmoney.data.remote.ApiService
import com.veda.virginmoney.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://61e947967bc0550017bc61bf.mockapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providePeopleApiData(apiService: ApiService) = ApiData(apiService)


    @Singleton
    @Provides
    fun provideRepository(remoteData: ApiData) =
        Repository(remoteData)
}