package com.example.catsbrowser.data.network.service

import com.example.catsbrowser.data.network.response.ApiResponseItem
import com.example.catsbrowser.data.network.response.BreedResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitBreedInterface {
//f062605c-18a3-4253-b2b1-80e07e81232c
    @GET("breeds")
    suspend fun getBreedsResponse(): List<BreedResponse>
}