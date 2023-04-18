package com.example.roomdamo2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdamo2.data.model.Ciudad

@Dao
interface CiudadDao {
    @Query("SELECT * FROM Ciudad ORDER BY nombre")
    fun getCiudades(): LiveData<List<Ciudad>>

    @Query("SELECT nombre FROM Ciudad WHERE id = :id")
    fun getNombreCiudad(ciudad: Ciudad): LiveData<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCiudad(ciudad: Ciudad)

    @Delete
    suspend fun deleteCiudad(ciudad: Ciudad)
}