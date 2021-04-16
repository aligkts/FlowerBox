package com.aligkts.flowerbox.scene.filter

import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseFullScreenBottomSheetFragment
import com.aligkts.flowerbox.databinding.FragmentFilterBottomSheetBinding
import com.aligkts.flowerbox.internal.extension.showMultipleChoiceDialog
import com.aligkts.flowerbox.internal.extension.showSingleChoiceDialog
import com.aligkts.flowerbox.uimodel.FilterItemUiModel
import com.aligkts.flowerbox.uimodel.FilterValueItemUiModel

/**
 * Created by Ali Göktaş on 14,April,2021
 */
class FilterBottomSheetFragment :
    BaseFullScreenBottomSheetFragment<FilterBottomSheetViewModel, FragmentFilterBottomSheetBinding>(),
    FilterCallback {

    private var onFilterSelectionCompleted: ((List<FilterValueItemUiModel>) -> Unit)? = null

    override val layoutId: Int = R.layout.fragment_filter_bottom_sheet

    override fun initialize() {
        super.initialize()
        binder.filterAdapter = FilterAdapter(this)
        binder.buttonApplyFilter.setOnClickListener {
            val currentList = binder.filterAdapter?.currentList?.toList()
            val selectedFilters = arrayListOf<FilterValueItemUiModel>()
            currentList?.map { it.values }?.forEach { item ->
                item.filter { it.isSelected }.forEach { selected ->
                    selectedFilters.add(selected)
                }
            }
            dismiss()
            if (selectedFilters.isNotEmpty()) {
                onFilterSelectionCompleted?.let { it.invoke(selectedFilters) }
            }
        }
    }

    override fun onFilterClick(filterItem: FilterItemUiModel) {
        val valuesNameList = filterItem.values.map { it.name }
        val valuesNameArray = valuesNameList.toTypedArray()
        val valuesSelectedStatusArray = filterItem.values.map { it.isSelected }.toBooleanArray()
        if (filterItem.isSingleChoice) {
            requireContext().showSingleChoiceDialog(
                title = filterItem.categoryName,
                values = valuesNameArray,
                defaultValue = 0,
                buttonAction = { dialog, which ->
                    dialog.dismiss()
                    filterItem.values[which].isSelected = true
                    (filterItem.selectedValues as ArrayList<String>).add(valuesNameArray[which])
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

        fun newInstance(onFilterSelectionCompleted: ((List<FilterValueItemUiModel>) -> Unit)?): FilterBottomSheetFragment {
            val fragment = FilterBottomSheetFragment()
            fragment.onFilterSelectionCompleted = onFilterSelectionCompleted
            return fragment
        }
    }
}
