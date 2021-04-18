package com.aligkts.flowerbox.scene.product

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseAndroidViewModel
import com.aligkts.flowerbox.domain.FetchFilteredProductListUseCase
import com.aligkts.flowerbox.domain.FetchProductListUseCase
import com.aligkts.flowerbox.internal.extension.getFilterRequestQuery
import com.aligkts.flowerbox.internal.util.Failure
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.FilterItemUiModel
import com.aligkts.flowerbox.uimodel.ProductItemUiModel
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 13,April,2021
 */

class ProductViewModel @Inject constructor(
    private val fetchProductListUseCase: FetchProductListUseCase,
    private val fetchFilteredProductListUseCase: FetchFilteredProductListUseCase,
    application: Application
) : BaseAndroidViewModel(application) {

    private val _products = MutableLiveData<List<ProductItemUiModel>>()
    val products: LiveData<List<ProductItemUiModel>> get() = _products

    var filterSelectionList: List<FilterItemUiModel>? = null

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

    fun fetchFilteredProductList(filterSelectionList: List<FilterItemUiModel>) {
        this.filterSelectionList = filterSelectionList
        showLoading()
        bgScope.launch {
            val filteredProductListResult =
                fetchFilteredProductListUseCase.run(
                    FetchFilteredProductListUseCase.Params(
                        filterSelectionList.getFilterRequestQuery()
                    )
                )
            onUIThread {
                dismissLoading()
                filteredProductListResult.either(::handleFailure, ::postProductList)
            }
        }
    }

    override fun handleFailure(failure: Failure) {
        super.handleFailure(failure)
        showSnackBar(failure.message ?: getString(R.string.common_error_unknown))
        filterSelectionList = null
    }

    private fun postProductList(products: List<ProductItemUiModel>) {
        _products.value = products
    }
}
