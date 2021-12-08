package com.task.data.remote

import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.remote.Resource


internal interface RemoteDataSource {
    suspend fun requestTest(): Resource<List<Test>>
}
