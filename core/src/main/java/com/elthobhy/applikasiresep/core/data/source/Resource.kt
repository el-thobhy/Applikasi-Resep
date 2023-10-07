package com.elthobhy.applikasiresep.core.data.source

import com.elthobhy.applikasiresep.core.utils.Status

data class Resource<T>(val status: Status, val data: T?, val message: String?) {
    companion object{
        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)

        fun <T> error(msg: String?, data: T?=null): Resource<T> = Resource(Status.ERROR,data,msg)

        fun <T> loading(data: T?=null): Resource<T> = Resource(Status.LOADING, data, null)
    }
}
