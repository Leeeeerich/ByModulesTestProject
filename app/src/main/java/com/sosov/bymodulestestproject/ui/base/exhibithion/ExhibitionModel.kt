package com.sosov.bymodulestestproject.ui.base.exhibithion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sosov.bymodulestestproject.model.repository.Repository
import com.sosov.model.Exhibit

class ExhibitionModel(private val repository: Repository) : ViewModel() {
    private var exhibitsLiveData = MutableLiveData<List<Exhibit>>()

    fun getExhibitsLiveData(): LiveData<List<Exhibit>> = exhibitsLiveData

    fun init() {
        exhibitsLiveData.postValue(repository.loadExhibits())
    }
}