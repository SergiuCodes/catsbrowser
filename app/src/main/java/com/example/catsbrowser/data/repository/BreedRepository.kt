package com.example.catsbrowser.data.repository

import com.example.catsbrowser.data.network.client.RetrofitClient
import com.example.catsbrowser.data.network.response.BreedResponse
import com.example.catsbrowser.domain.model.Breed
import com.example.catsbrowser.ui.ApiUiBreedMapper
import timber.log.Timber

class BreedRepository {

    suspend fun getBreeds(): List<Breed> {
        val response: List<BreedResponse> = getBreedsResponse()
        val mappedResponse = ApiUiBreedMapper().mapListBreeds(response)

        Timber.d("GetBreeds response size: " + mappedResponse.size)
        return mappedResponse
    }

    private suspend fun getBreedsResponse(): List<BreedResponse> {
        return RetrofitClient.getInstance().getInterface().getBreedsResponse()
    }
}