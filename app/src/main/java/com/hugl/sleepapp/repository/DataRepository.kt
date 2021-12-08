package com.task.data

import com.hugl.sleepapp.model.Test
import com.hugl.sleepapp.remote.RemoteData
import com.hugl.sleepapp.remote.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class DataRepository @Inject constructor(private val remoteRepository: RemoteData, private val ioDispatcher: CoroutineContext) : DataRepositorySource {

    override suspend fun requestTest(): Flow<Resource<List<Test>>> {
        return flow {
            emit(remoteRepository.requestTest())
        }.flowOn(ioDispatcher)
    }


}
