package com.aligkts.flowerbox.scene.filter

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseFullScreenBottomSheetFragment
import com.aligkts.flowerbox.databinding.FragmentFilterBottomSheetBinding
import com.aligkts.flowerbox.internal.extension.showMultipleChoiceDialog
import com.aligkts.flowerbox.internal.extension.showSingleChoiceDialog
import com.aligkts.flowerbox.uimodel.FilterItemUiModel

/**
 * Created by Ali Göktaş on 14,April,2021
 */
class FilterBottomSheetFragment :
    BaseFullScreenBottomSheetFragment<FilterBottomSheetViewModel, FragmentFilterBottomSheetBinding>(),
    FilterCallback {

    lateinit var onFilterSelectionCompleted: ((List<FilterItemUiModel>) -> Unit)

    private var filterSelectionList: List<FilterItemUiModel>? = null

    override val layoutId: Int = R.layout.fragment_filter_bottom_sheet

    override fun initialize() {
        super.initialize()
        filterSelectionList?.let { viewModel.setFilterSelectionList(it) }
        setupBindings()
    }

    private fun setupBindings() {
        with(binder) {
            filterAdapter = FilterAdapter(this@FilterBottomSheetFragment)
            imgClose.setOnClickListener { dismiss() }
            buttonApplyFilter.setOnClickListener {
                val currentList = binder.filterAdapter?.currentList?.toList()
                val selectedFilters = arrayListOf<FilterItemUiModel>()
                currentList?.forEach { item ->
                    if (item.values.any { it.isSelected }) {
                        selectedFilters.add(item)
                    }
                }
                dismiss()
                if (selectedFilters.isNotEmpty()) {
                    onFilterSelectionCompleted.invoke(selectedFilters)
                } else {
                    onFilterSelectionCompleted.invoke(emptyList())
                }
            }
            txtClearFilter.setOnClickListener {
                this@FilterBottomSheetFragment.viewModel.clearFilters()
                binder.filterAdapter?.notifyDataSetChanged()
            }
        }
    }

    override fun onFilterClick(filterItem: FilterItemUiModel) {
        val valuesNameList = filterItem.values.map { it.name }
        val valuesNameArray = valuesNameList.toTypedArray()
        val valuesSelectedStatusArray = filterItem.values.map { it.isSelected }.toBooleanArray()
        if (filterItem.isSingleChoice) {
            val selectedSingleChoiceItem = filterItem.values.find { it.isSelected }
            val selectedSingleChoiceItemIndex = filterItem.values.indexOf(selectedSingleChoiceItem)
            requireContext().showSingleChoiceDialog(
                title = filterItem.categoryName,
                values = valuesNameArray,
                defaultValue = selectedSingleChoiceItemIndex,
                buttonAction = { dialog, which ->
                    dialog.dismiss()
                    filterItem.values.forEachIndexed { index, filterValueItem ->
                        if (index == which) {
                            filterValueItem.isSelected = true
                            filterItem.selectedValues.add(valuesNameArray[index])
                        } else {
                            filterValueItem.isSelected = false
                            filterItem.selectedValues.remove(valuesNameArray[index])
                        }
                    }
                    viewModel.replaceFilteredItem(filterItem)
                    binder.filterAdapter?.notifyDataSetChanged()
                }
            )
        } else {
            requireContext().showMultipleChoiceDialog(
                title = filterItem.categoryName,
                values = valuesNameArray,
                defaultValue = valuesSelectedStatusArray,
                buttonAction = { dialog, which, isChecked ->
                    filterItem.values[which].isSelected = isChecked
                    val selectedList = (filterItem.selectedValues as ArrayList<String>)
                    if (isChecked) {
                        selectedList.add(valuesNameArray[which])
                    } else {
                        selectedList.remove(valuesNameArray[which])
                    }
                    viewModel.replaceFilteredItem(filterItem)
                    binder.filterAdapter?.notifyDataSetChanged()
                }
            )
        }
    }

    companion object {
        const val TAG = "FilterBottomSheetFragment"

        fun newInstance(
            selectedFilters: List<FilterItemUiModel>?,
            onFilterSelectionCompleted: ((List<FilterItemUiModel>) -> Unit)
        ): FilterBottomSheetFragment {
            val fragment = FilterBottomSheetFragment()
            fragment.onFilterSelectionCompleted = onFilterSelectionCompleted
            selectedFilters?.let { fragment.filterSelectionList = it }
            return fragment
        }
    }
}
