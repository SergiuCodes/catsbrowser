package com.example.catsbrowser.data.network.client

import com.example.catsbrowser.data.network.service.RetrofitBreedInterface
import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var mInterface: RetrofitBreedInterface
    val API_KEY = "Basic f062605c-18a3-4253-b2b1-80e07e81232c"

    companion object {

        private var mInstance: RetrofitClient? = null
        fun getInstance(): RetrofitClient {
            if (mInstance == null) {
                mInstance = RetrofitClient()
            }
            return mInstance!!
        }
    }

    init {
        mInterface = getClient("https://api.thecatapi.com/v1/").create(RetrofitBreedInterface::class.java)
    }

    fun getInterface(): RetrofitBreedInterface = mInterface

    private fun getClient(url: String): Retrofit {
        val mTimeOutNr = 30L
        val mTimeOutType = TimeUnit.SECONDS

        val client: OkHttpClient = OkHttpClient().newBuilder()
            .callTimeout(mTimeOutNr, mTimeOutType)
            .connectTimeout(mTimeOutNr, mTimeOutType)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addInterceptor(Interceptor{chain: Interceptor.Chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization",API_KEY).build()
                chain.proceed(request)
            })
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(url)
            .build()
    }
}


