package com.aligkts.flowerbox.data.remote.model.product

import com.aligkts.flowerbox.data.remote.BaseRequestModel

/**
 * Created by Ali Göktaş on 16,April,2021
 */
data class FilteredProductListRequestModel(
    val query: String
) : BaseRequestModel()
