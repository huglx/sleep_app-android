package com.hugl.sleepapp.remote

import com.hugl.sleepapp.utils.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


private const val timeoutRead = 30   //In seconds
private const val contentType = "Content-Type"
private const val contentTypeValue = "application/json"
private const val timeoutConnect = 30   //In seconds

@Singleton
class ServiceGenerator @Inject constructor() {
    private val retrofit: Retrofit

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}
