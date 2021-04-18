package com.aligkts.flowerbox.domain

import com.aligkts.flowerbox.data.remote.model.request.product.FilteredProductListRequestModel
import com.aligkts.flowerbox.data.repository.ProductRepository
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.ProductItemUiModel
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 16,April,2021
 */

class FetchFilteredProductListUseCase @Inject constructor(
    private val repository: ProductRepository
) : UseCase<List<ProductItemUiModel>, FetchFilteredProductListUseCase.Params>() {

    override suspend fun buildUseCase(params: Params) =
        repository.fetchFilteredProductList(FilteredProductListRequestModel(query = params.query))
            .toUiModel()

    data class Params(val query: String)
}
