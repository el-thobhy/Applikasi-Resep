package com.elthobhy.applikasiresep.ui.area

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase

class AreaViewModel(private val userCase: UseCase): ViewModel() {
    fun getArea(): LiveData<Resource<List<DomainArea>>> = userCase.getArea().asLiveData()
}