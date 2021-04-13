package com.aligkts.flowerbox.scene.product

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseListAdapter
import com.aligkts.flowerbox.databinding.RecyclerviewItemProductBinding
import com.aligkts.flowerbox.internal.extension.executeAfter
import com.aligkts.flowerbox.uimodel.ProductItemUiModel

/**
 * Created by Ali Göktaş on 13,April,2021
 */
interface ProductCallback {
    fun onProductClick(product: ProductItemUiModel)
}

class ProductAdapter(
    private val productCallback: ProductCallback
) : BaseListAdapter<RecyclerviewItemProductBinding, ProductItemUiModel>() {

    override val layoutRes: Int get() = R.layout.recyclerview_item_product

    override fun bind(binding: RecyclerviewItemProductBinding, item: ProductItemUiModel) {
        binding.executeAfter {
            callback = productCallback
            product = item
        }
    }
}
