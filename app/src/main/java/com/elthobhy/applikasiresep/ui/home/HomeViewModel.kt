package com.elthobhy.applikasiresep.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase

class HomeViewModel(private val useCase: UseCase): ViewModel() {
    fun getPopular(): LiveData<Resource<List<DomainMain>>> = useCase.getMain().asLiveData()
}