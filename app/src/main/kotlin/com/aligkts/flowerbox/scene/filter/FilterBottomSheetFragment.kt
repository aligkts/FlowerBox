package com.aligkts.flowerbox.scene.filter

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseFullScreenBottomSheetFragment
import com.aligkts.flowerbox.databinding.FragmentFilterBottomSheetBinding
import com.aligkts.flowerbox.uimodel.FilterItemUiModel

/**
 * Created by Ali Göktaş on 14,April,2021
 */
class FilterBottomSheetFragment :
    BaseFullScreenBottomSheetFragment<FilterBottomSheetViewModel, FragmentFilterBottomSheetBinding>(), FilterCallback {

    override val layoutId: Int = R.layout.fragment_filter_bottom_sheet

    override fun initialize() {
        super.initialize()
        binder.filterAdapter = FilterAdapter(this)
    }

    override fun onFilterClick(filterItem: FilterItemUiModel) {
    }
}
