package com.iverse.core.data.repository.auth.login

import com.iverse.core.base.Resource
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.model.auth.login.LoginResponseModel
import com.iverse.core.domain.repository.auth.login.LoginRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginRepositoryImpl(private val client: HttpClient) : LoginRepository {

    override suspend fun loginToAccount(model: LoginRequestModel?): Resource<LoginResponseModel?> {
        return withContext(Dispatchers.IO) {
            val response: HttpResponse = client.post("http://192.168.2.247:4000/api/login") {
                method = HttpMethod.Post
                body = model!!
                contentType(ContentType.Application.Json)
            }
            when (response.status.value) {
                200 -> {
                    Resource.success(response.receive())
                }
                else -> {
                    Resource.error(response.status.description)
                }
            }
        }
    }

}