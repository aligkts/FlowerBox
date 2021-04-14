package com.aligkts.flowerbox.scene.filter

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseListAdapter
import com.aligkts.flowerbox.databinding.RecyclerviewItemFilterBinding
import com.aligkts.flowerbox.internal.extension.executeAfter
import com.aligkts.flowerbox.uimodel.FilterItemUiModel

/**
 * Created by Ali Göktaş on 14,April,2021
 */

interface FilterCallback {
    fun onFilterClick(filterItem: FilterItemUiModel)
}

class FilterAdapter(
    private val filterCallback: FilterCallback
) : BaseListAdapter<RecyclerviewItemFilterBinding, FilterItemUiModel>() {

    override val layoutRes: Int get() = R.layout.recyclerview_item_filter

    override fun bind(binding: RecyclerviewItemFilterBinding, item: FilterItemUiModel) {
        binding.executeAfter {
            filterItem = item
        }
    }
}
