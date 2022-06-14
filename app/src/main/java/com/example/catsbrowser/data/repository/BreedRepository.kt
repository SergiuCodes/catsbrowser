package com.example.catsbrowser.data.repository

import android.util.Log
import com.example.catsbrowser.data.network.client.RetrofitClient
import com.example.catsbrowser.data.network.responsetest.BreedResponseTest
import com.example.catsbrowser.domain.model.Breed
import com.example.catsbrowser.domain.model.BreedViewModel
import com.example.catsbrowser.ui.ApiUiBreedMapper
import kotlinx.coroutines.*

class BreedRepository(private val mViewModel: BreedViewModel) {

    suspend fun getBreedsResponse(): BreedResponseTest {
        return RetrofitClient.getInstance().getInterface().getBreedsResponse()
    }

    fun successGetBreeds(nResponse: List<Breed>){
        mViewModel.mUiBreedsList.postValue(nResponse)
    }

    fun getBreeds(nScope: CoroutineScope){
        nScope.launch(mGetBreedsError) {
            withContext(Dispatchers.IO){

                val mappedResponse: List<Breed>
                val response: BreedResponseTest = getBreedsResponse()

                mappedResponse = ApiUiBreedMapper().mapListBreeds(response)

                Log.d("TEST"," testing repository" + mappedResponse.size)
                successGetBreeds(mappedResponse)
            }
        }
    }
    protected val mGetBreedsError = CoroutineExceptionHandler { _, nError ->
        Log.d("error", "coroutine repository error: $nError")
    }
}