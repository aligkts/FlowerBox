package com.aligkts.flowerbox.scene.product

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseFragment
import com.aligkts.flowerbox.databinding.FragmentProductBinding
import com.aligkts.flowerbox.internal.extension.liveDataObserver
import com.aligkts.flowerbox.internal.extension.toast
import com.aligkts.flowerbox.uimodel.ProductListUiModel

/**
 * Created by Ali Göktaş on 13,April,2021
 */

class ProductFragment : BaseFragment<ProductViewModel, FragmentProductBinding>() {

    override val layoutId: Int get() = R.layout.fragment_product

    override fun initialize() {
        super.initialize()
        liveDataObserver(viewModel.products, ::showResponse)
    }

    private fun showResponse(data: ProductListUiModel) {
        toast(data.products)
    }
}
