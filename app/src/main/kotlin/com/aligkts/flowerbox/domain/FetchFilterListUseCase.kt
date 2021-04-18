package com.aligkts.flowerbox.domain

import com.aligkts.flowerbox.data.repository.FilterRepository
import com.aligkts.flowerbox.internal.util.UseCase
import com.aligkts.flowerbox.uimodel.FilterItemUiModel
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 14,April,2021
 */

class FetchFilterListUseCase @Inject constructor(
    private val repository: FilterRepository
) : UseCase<List<FilterItemUiModel>, UseCase.None>() {

    override suspend fun buildUseCase(params: None) = repository.fetchFilterList()
}
