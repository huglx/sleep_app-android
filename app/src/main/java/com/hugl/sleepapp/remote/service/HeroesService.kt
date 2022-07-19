package com.task.data.remote.service

import com.hugl.sleepapp.model.Test
import retrofit2.Response
import retrofit2.http.GET

interface TestService {
    @GET("files")
    suspend fun fetchFiles(): Response<List<Test>>
}
