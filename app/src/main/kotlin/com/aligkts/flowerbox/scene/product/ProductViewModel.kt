package com.aligkts.flowerbox.scene.product

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligkts.flowerbox.base.BaseAndroidViewModel
import com.aligkts.flowerbox.domain.FetchProductListUseCase
import com.aligkts.flowerbox.internal.util.Failure
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.ProductItemUiModel
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 13,April,2021
 */

class ProductViewModel @Inject constructor(
    private val fetchProductListUseCase: FetchProductListUseCase,
    application: Application
) : BaseAndroidViewModel(application) {

    private val _errorOccured = MutableLiveData<Boolean>()
    val errorOccured: LiveData<Boolean> get() = _errorOccured

    private val _products = MutableLiveData<List<ProductItemUiModel>>()
    val products: LiveData<List<ProductItemUiModel>> get() = _products

    init {
        fetchProductList()
    }

    private fun fetchProductList() {
        showLoading()
        bgScope.launch {
            val productListResult = fetchProductListUseCase.run(UseCase.None)
            onUIThread {
                dismissLoading()
                productListResult.either(::handleFailure, ::postProductList)
            }
        }
    }

    override fun handleFailure(failure: Failure) {
        super.handleFailure(failure)
        _errorOccured.value = true
    }

    private fun postProductList(products: List<ProductItemUiModel>) {
        _products.value = products
    }

    fun onFilterClick() {
        navigateToFilterFragment()
    }

    private fun navigateToFilterFragment() {
        navigate(ProductFragmentDirections.toFilter())
    }
}
