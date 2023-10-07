package com.elthobhy.applikasiresep.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase

class FavoriteViewModel(private val useCase: UseCase): ViewModel() {
    fun getFav(): LiveData<List<DomainDetail>> = useCase.getFav().asLiveData()
}