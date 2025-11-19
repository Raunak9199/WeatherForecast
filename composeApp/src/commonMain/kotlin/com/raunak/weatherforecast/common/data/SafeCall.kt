package com.raunak.weatherforecast.common.data

import com.raunak.weatherforecast.utils.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

/**
 * A convenience function for making safe HTTP requests with Ktor's HttpClient.
 *
 * This function wraps the actual HTTP request in a coroutine flow that emits a [Response] object
 * with the loading state, and then emits a [Response.Success] object with the HTTP response body.
 *
 * @param block The block of code to execute for the HTTP request.
 * @return A flow of [Response] objects.
 */
inline fun <reified T, reified E> HttpClient.safeRequest(crossinline block: HttpRequestBuilder.() -> Unit): Flow<Response<T, E>> =
    flow<Response<T, E>> {
        emit(Response.Loading)
        val response = request { block() }
        emit(Response.Success(response.body<T>()))
    }

/**
 * A utility function for extracting the error body from a [ResponseException].
 *
 * This function attempts to deserialize the error body from the [ResponseException.response]
 * to a specific type [E]. If the deserialization fails with a [SerializationException], it
 * returns null.
 *
 * @return The deserialized error body, or null if the deserialization fails.
 */
suspend inline fun <reified E> ResponseException.errorBody(): E? = try {
    response.body<E>()
} catch (e: SerializationException) {
    null
}