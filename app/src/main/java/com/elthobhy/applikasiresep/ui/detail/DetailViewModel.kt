package com.elthobhy.applikasiresep.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase

class DetailViewModel(private val useCase: UseCase): ViewModel() {
    fun getDetail(id: String): LiveData<Resource<List<DomainDetail>>> = useCase.getDetail(id).asLiveData()
}