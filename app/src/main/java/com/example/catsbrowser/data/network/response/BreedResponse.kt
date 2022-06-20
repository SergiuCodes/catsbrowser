package com.example.catsbrowser.data.network.response

data class BreedResponse(

    val name: String,
    val image: Image = Image(),

    //later for details fragment
//    val wikipedia_url: String
)