package com.example.roomdamo2.data.repository

import androidx.lifecycle.LiveData
import com.example.roomdamo2.data.dao.CiudadDao
import com.example.roomdamo2.data.model.Ciudad

class CiudadRepository(private val ciudadDao: CiudadDao) {
    val  ciudades: LiveData<List<Ciudad>> = ciudadDao.getCiudades()

    suspend fun addCiudad(ciudad: Ciudad){
        ciudadDao.addCiudad(ciudad)
    }
}