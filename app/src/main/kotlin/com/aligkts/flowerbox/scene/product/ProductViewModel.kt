package com.aligkts.flowerbox.scene.product

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligkts.flowerbox.base.BaseAndroidViewModel
import com.aligkts.flowerbox.domain.FetchProductListUseCase
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.ProductListUiModel
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 13,April,2021
 */

class ProductViewModel @Inject constructor(
    private val fetchProductListUseCase: FetchProductListUseCase,
    application: Application
) : BaseAndroidViewModel(application) {

    private val _products = MutableLiveData<ProductListUiModel>()
    val products: LiveData<ProductListUiModel> get() = _products

    init {
        fetchProductList()
    }

    private fun fetchProductList() {
        bgScope.launch {
            val productListResult = fetchProductListUseCase.run(UseCase.None)
            onUIThread {
                productListResult.either(::handleFailure, ::postProductList)
            }
        }
    }

    private fun postProductList(products: ProductListUiModel) {
        _products.value = products
    }
}
