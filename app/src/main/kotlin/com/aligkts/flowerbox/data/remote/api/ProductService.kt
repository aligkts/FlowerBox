package com.aligkts.flowerbox.data.remote.api

import com.aligkts.flowerbox.data.remote.model.product.ProductListResponseModel
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by Ali Göktaş on 13,April,2021
 */
interface ProductService {

    @GET(PRODUCT_LIST)
    suspend fun fetchProductList(): ProductListResponseModel

    @GET
    suspend fun fetchFilteredProductList(@Url query: String): ProductListResponseModel

    companion object {
        const val PRODUCT_LIST = "dynamicproductlist"
    }
}
