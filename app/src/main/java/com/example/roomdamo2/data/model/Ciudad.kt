package com.example.roomdamo2.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ciudad")
data class Ciudad (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idCiudad")
    val idCiudad: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "poblacion")
    val poblacion: Int
)