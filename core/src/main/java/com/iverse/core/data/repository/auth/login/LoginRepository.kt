package com.iverse.core.data.repository.auth.login

import com.iverse.core.base.Resource
import com.iverse.core.data.entities.auth.login.LoginRequestModel
import com.iverse.core.data.entities.auth.login.LoginResponseModel
import com.iverse.core.data.entities.fake.FakeModel
import com.iverse.core.data.remote.auth.login.LoginRemoteService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginRepository(private val client: HttpClient) : LoginRemoteService {

    override suspend fun loginToAccount(model: LoginRequestModel): Resource<LoginResponseModel?> {
        return withContext(Dispatchers.IO) {
            val response: HttpResponse = client.post("http://192.168.2.247:4000/api/login") {
                method = HttpMethod.Post
                body = model
                contentType(ContentType.Application.Json)
            }
            when (response.status.value) {
                200 -> {
                    Resource.success(response.receive())
                }
                else -> {
                    Resource.error("")
                }
            }
        }
    }

}