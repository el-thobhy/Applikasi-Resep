package com.elthobhy.applikasiresep.ui.area

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AreaViewModel @Inject constructor(private val userCase: UseCase): ViewModel() {
    fun getAreaList(strArea: String): LiveData<Resource<List<DomainMain>>> = userCase.getAreaList(strArea).asLiveData()
}