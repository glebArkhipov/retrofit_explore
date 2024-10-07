package com

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.io.IOException

suspend fun makeApiCall() {
    val api = createCatApi()
    api.callThatReturns404()
}

private fun createCatApi(): CatApi {
    val url = "https://cat-fact.herokuapp.com/"
    val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val response = chain.proceed(chain.request())
            if (!response.isSuccessful) {
                throw SubTypeOfIOException(response)
            }
            response
        }
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerKotlinModule()))
        .client(httpClient)
        .build()
    return retrofit.create<CatApi>()
}

interface CatApi {
    @GET("factss")
    suspend fun callThatReturns404(): Collection<Any>
}

class SubTypeOfIOException(response: okhttp3.Response) : IOException(response.code.toString())
