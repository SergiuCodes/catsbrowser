package com.example.catsbrowser.domain.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.catsbrowser.data.repository.BreedRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class BreedViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {

    var breedList = MutableLiveData<List<Breed>>()
    private var repository: BreedRepository = BreedRepository()

    fun getBreeds() {
        viewModelScope.launch(Dispatchers.IO + mGetBreedsError) {
            breedList.postValue(repository.getBreeds())
        }
    }

    private val mGetBreedsError = CoroutineExceptionHandler { _, nError ->
        Timber.d("BreedList response error: " + nError)
    }
}