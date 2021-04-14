package com.aligkts.flowerbox.data.remote.datasource

import com.aligkts.flowerbox.data.remote.BaseRemoteDataSource
import com.aligkts.flowerbox.data.remote.api.ProductService
import com.aligkts.flowerbox.data.remote.model.product.MainFilterResponseModel
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 14,April,2021
 */

class FilterRemoteDataSource @Inject constructor(
    private val service: ProductService
) : BaseRemoteDataSource() {

    suspend fun fetchFilterList(): MainFilterResponseModel = invoke {
        service.fetchProductList().result.data.mainFilter
    }
}
