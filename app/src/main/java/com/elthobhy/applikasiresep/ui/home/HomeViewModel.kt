package com.elthobhy.applikasiresep.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainPopular
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase

class HomeViewModel(private val useCase: UseCase): ViewModel() {
    fun getPopular(): LiveData<Resource<List<DomainPopular>>> = useCase.getPopular().asLiveData()
}