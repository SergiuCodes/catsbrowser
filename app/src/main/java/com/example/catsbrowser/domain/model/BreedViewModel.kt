package com.example.catsbrowser.domain.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.catsbrowser.data.repository.BreedRepository

class BreedViewModel(application: Application): AndroidViewModel(application), LifecycleObserver{

    var mUiBreedsList = MutableLiveData<List<Breed>>()
    private var mRepository: BreedRepository = BreedRepository(this)

    fun getBreeds() {
        mRepository.getBreeds(viewModelScope)
    }

}