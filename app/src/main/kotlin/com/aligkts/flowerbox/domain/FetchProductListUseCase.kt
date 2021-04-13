package com.aligkts.flowerbox.domain

import com.aligkts.flowerbox.data.repository.ProductRepository
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.ProductItemUiModel
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 13,April,2021
 */
class FetchProductListUseCase @Inject constructor(
    private val repository: ProductRepository
) : UseCase<List<ProductItemUiModel>, UseCase.None>() {

    override suspend fun buildUseCase(params: None) = repository.fetchDynamicProductList()
}
