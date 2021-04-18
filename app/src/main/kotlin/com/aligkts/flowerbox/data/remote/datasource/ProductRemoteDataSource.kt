package com.aligkts.flowerbox.data.remote.datasource

import com.aligkts.flowerbox.data.remote.BaseRemoteDataSource
import com.aligkts.flowerbox.data.remote.api.ProductService
import com.aligkts.flowerbox.data.remote.model.product.FilteredProductListRequestModel
import com.aligkts.flowerbox.data.remote.model.product.ProductListResponseModel
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 13,April,2021
 */
class ProductRemoteDataSource @Inject constructor(
    private val service: ProductService
) : BaseRemoteDataSource() {

    suspend fun fetchProductList(): ProductListResponseModel = invoke {
        service.fetchProductList()
    }

    suspend fun fetchFilteredProductList(request: FilteredProductListRequestModel): ProductListResponseModel =
        invoke {
            service.fetchFilteredProductList(ProductService.PRODUCT_LIST.plus(request.query))
        }
}
