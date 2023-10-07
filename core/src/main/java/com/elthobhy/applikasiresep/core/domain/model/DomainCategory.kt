package com.elthobhy.applikasiresep.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainCategory (
    val strCategory: String? = null,
    val strCategoryDescription: String? = null,
    val idCategory: String,
    val strCategoryThumb: String? = null
): Parcelable