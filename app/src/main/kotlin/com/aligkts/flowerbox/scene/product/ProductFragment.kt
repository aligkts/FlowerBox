package com.aligkts.flowerbox.scene.product

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseFragment
import com.aligkts.flowerbox.databinding.FragmentProductBinding
import com.aligkts.flowerbox.internal.extension.toast
import com.aligkts.flowerbox.scene.filter.FilterBottomSheetFragment
import com.aligkts.flowerbox.uimodel.ProductItemUiModel

/**
 * Created by Ali Göktaş on 13,April,2021
 */

class ProductFragment : BaseFragment<ProductViewModel, FragmentProductBinding>(), ProductCallback {

    override val layoutId: Int get() = R.layout.fragment_product

    override fun initialize() {
        super.initialize()
        binder.productAdapter = ProductAdapter(this)
        binder.txtFilter.setOnClickListener {
            FilterBottomSheetFragment.newInstance { selections ->
                viewModel.fetchFilteredProductList(filterSelectionList = selections)
            }.show(childFragmentManager, FilterBottomSheetFragment.TAG)
        }
    }

    override fun onProductClick(product: ProductItemUiModel) {
        toast(product.title)
    }
}
