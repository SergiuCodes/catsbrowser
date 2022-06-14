package com.example.catsbrowser.ui

import com.example.catsbrowser.data.network.response.BreedResponse
import com.example.catsbrowser.data.network.responsetest.BreedResponseTest
import com.example.catsbrowser.domain.model.Breed

class ApiUiBreedMapper {

    fun mapApiBreedToUi(breed: BreedResponse): Breed {
        return Breed(
            imageUrl = breed.imageResponse.url,
            name = breed.name
        )
    }

    fun mapListBreeds(apiResponse: BreedResponseTest): ArrayList<Breed> {

        val mappedListBreeds: ArrayList<Breed> = ArrayList()
        val mappedBreed: Breed

        for (item in apiResponse) {

            val mappedBreed = Breed()

            with(mappedBreed) {
                name = item.name!!
                imageUrl = item.image!!.url
            }
            mappedListBreeds.add(mappedBreed)

        }
        return mappedListBreeds
    }
}