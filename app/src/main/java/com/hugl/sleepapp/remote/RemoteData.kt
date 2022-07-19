package com.hugl.sleepapp.remote

import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.utils.NetworkConnectivity
import com.task.data.remote.RemoteDataSource
import com.task.data.remote.service.TestService
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator, private val networkConnectivity: NetworkConnectivity) :
    RemoteDataSource {

    override suspend fun requestTest(): Resource<List<Test>> {
        val testService = serviceGenerator.createService(TestService::class.java)
        return when (val response = processCall(testService::fetchFiles)) {
            is List<*> -> {
                Resource.Success(data = response as List<Test>)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return -1
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            -2
        }
    }
}
