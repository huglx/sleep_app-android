package com.task.data

import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.remote.Resource
import kotlinx.coroutines.flow.Flow


interface DataRepositorySource {
    suspend fun requestTest(): Flow<Resource<List<Test>>>

}
