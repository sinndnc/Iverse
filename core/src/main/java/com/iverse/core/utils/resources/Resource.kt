package com.iverse.core.utils.resources



import androidx.lifecycle.LiveData
import kotlinx.serialization.Serializable


enum class Status { SUCCESS, ERROR, LOADING }

@Serializable
data class Resource<T>(val status: Status, val data: T?, val message: String?) : LiveData<T>() {


    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}