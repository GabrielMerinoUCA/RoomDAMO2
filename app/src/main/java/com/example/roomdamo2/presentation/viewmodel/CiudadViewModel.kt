package com.example.roomdamo2.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdamo2.data.database.BaseDatos
import com.example.roomdamo2.data.model.Ciudad
import com.example.roomdamo2.data.repository.CiudadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CiudadViewModel(application: Application): AndroidViewModel(application) {
    private val ciudades: LiveData<List<Ciudad>>
    private val repository: CiudadRepository

    init {
        val ciudadDao = BaseDatos.getDatabase(application).CiudadDao()
        repository = CiudadRepository(ciudadDao)
        ciudades = repository.ciudades
    }

    fun addCiudad(ciudad: Ciudad){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCiudad(ciudad)
        }
    }
}