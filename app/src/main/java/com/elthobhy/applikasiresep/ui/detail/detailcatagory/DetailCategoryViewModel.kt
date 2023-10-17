package com.elthobhy.applikasiresep.ui.detail.detailcatagory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailCategoryViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun getListCategory(
        strCategory: String,
        isBeef: Boolean,
        isBreakfast: Boolean,
        isChicken: Boolean,
        isDessert: Boolean,
        isGoat: Boolean,
        isLamb: Boolean,
        isMiscellaneous: Boolean,
        isPasta: Boolean,
        isPork: Boolean,
        isSeafood: Boolean,
        isSide: Boolean,
        isStarter: Boolean,
        isVegan: Boolean,
        isVegetarian: Boolean,
    ): LiveData<Resource<List<DomainMeal>>> =
        useCase.getListCategory(
            strCategory, isBeef,
            isBreakfast,
            isChicken,
            isDessert,
            isGoat,
            isLamb,
            isMiscellaneous,
            isPasta,
            isPork,
            isSeafood,
            isSide,
            isStarter,
            isVegan,
            isVegetarian,
        ).asLiveData()
}