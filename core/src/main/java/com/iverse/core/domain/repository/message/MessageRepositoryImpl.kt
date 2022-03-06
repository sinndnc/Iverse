package com.iverse.core.domain.repository.message

import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.auth.login.Message
import com.iverse.core.domain.model.message.MessageRequestModel
import com.iverse.core.utils.resources.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MessageRepositoryImpl (private val client: HttpClient) : MessageRepository {

    override suspend fun fetchUserMessageList(id: MessageRequestModel): Resource<List<Message>> =
        withContext(Dispatchers.IO) {
            val response: HttpResponse = client.post("http://192.168.2.247:4000/api/fetch/message") {
                method = HttpMethod.Post
                body = id
                contentType(ContentType.Application.Json)
            }
            when (response.status) {
                HttpStatusCode.OK -> {
                    Resource.success(response.receive())
                }
                HttpStatusCode.NotFound -> {
                    Resource.error(response.status.description)
                }
                else -> Resource.loading()
            }
        }


}