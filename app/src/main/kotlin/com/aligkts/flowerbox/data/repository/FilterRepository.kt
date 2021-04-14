package com.aligkts.flowerbox.data.repository

import com.aligkts.flowerbox.data.remote.datasource.FilterRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ali Göktaş on 14,April,2021
 */

@Singleton
class FilterRepository @Inject constructor(
    private val remoteDataSource: FilterRemoteDataSource
) {

    suspend fun fetchFilterList() = remoteDataSource.fetchFilterList().toUiModel()
}
