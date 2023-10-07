package com.elthobhy.applikasiresep.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase

class DetailViewModel(private val useCase: UseCase): ViewModel() {
    fun getDetail(id: String): LiveData<Resource<List<DomainDetail>>> = useCase.getDetail(id).asLiveData()
    fun setFav(model: DomainDetail){
        val newState = !model.isFavorite
        useCase.setFav(newState,model)
        Log.e("new", "setFav: $model" )
    }
    fun getFav(): LiveData<List<DomainDetail>> {
        return useCase.getFav().asLiveData()
    }

}