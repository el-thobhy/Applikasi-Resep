package com.elthobhy.applikasiresep.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    fun getPopular(): LiveData<Resource<List<DomainMain>>> = useCase.getMain().asLiveData()
    fun getArea(): LiveData<Resource<List<Domain>>> = useCase.getArea().asLiveData()
    fun getCategory(): LiveData<Resource<List<DomainCategory>>> = useCase.getCategory().asLiveData()
}