package com.aligkts.flowerbox.data.repository

import com.aligkts.flowerbox.data.remote.datasource.ProductRemoteDataSource
import com.aligkts.flowerbox.data.remote.model.product.FilteredProductListRequestModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ali Göktaş on 13,April,2021
 */
@Singleton
class ProductRepository @Inject constructor(
    private val remoteDataSource: ProductRemoteDataSource
) {
    suspend fun fetchDynamicProductList() = remoteDataSource.fetchProductList().toUiModel()

    suspend fun fetchFilteredProductList(request: FilteredProductListRequestModel) =
        remoteDataSource.fetchFilteredProductList(request = request)
}
