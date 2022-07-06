package com.example.catsbrowser.ui

import com.example.catsbrowser.data.network.response.BreedResponse
import com.example.catsbrowser.domain.model.Breed

class ApiUiBreedMapper {

    fun mapListBreeds(apiResponse: List<BreedResponse>): ArrayList<Breed> {

        val mappedListBreeds: ArrayList<Breed> = ArrayList()
        val mappedBreed: Breed

        apiResponse.forEach {

            val mappedBreed = Breed()
            mappedBreed.name = it.name
            mappedBreed.imageUrl = it.image?.url
            mappedBreed.description = it.description
            mappedListBreeds.add(mappedBreed)
        }
        return mappedListBreeds
    }
}