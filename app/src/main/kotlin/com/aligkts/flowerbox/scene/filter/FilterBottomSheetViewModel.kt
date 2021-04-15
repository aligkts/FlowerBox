package com.aligkts.flowerbox.scene.filter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligkts.flowerbox.base.BaseAndroidViewModel
import com.aligkts.flowerbox.domain.FetchFilterListUseCase
import com.aligkts.flowerbox.internal.extension.replace
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.FilterItemUiModel
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 14,April,2021
 */
class FilterBottomSheetViewModel @Inject constructor(
    private val fetchFilterListUseCase: FetchFilterListUseCase,
    application: Application
) : BaseAndroidViewModel(application) {

    private val _filters = MutableLiveData<List<FilterItemUiModel>>()
    val filters: LiveData<List<FilterItemUiModel>> get() = _filters

    init {
        fetchFilterList()
    }

    private fun fetchFilterList() {
        showLoading()
        bgScope.launch {
            val filterListResult = fetchFilterListUseCase.run(UseCase.None)
            onUIThread {
                dismissLoading()
                filterListResult.either(::handleFailure, ::postFilterList)
            }
        }
    }

    private fun postFilterList(filters: List<FilterItemUiModel>) {
        _filters.value = filters
    }

    fun replaceFilteredItem(newItem: FilterItemUiModel) {
        val newFilterList = _filters.value ?: emptyList()
        val oldItem = newFilterList.find { it.id == newItem.id }
        newFilterList.replace(old = oldItem, new = newItem)
        postFilterList(newFilterList)
    }
}
