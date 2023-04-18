package com.example.roomdamo2.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdamo2.data.dao.CiudadDao

abstract class BaseDatos : RoomDatabase() {
    abstract fun CiudadDao(): CiudadDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDatos? = null

        fun getDatabase(context: Context): BaseDatos{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                BaseDatos::class.java,
                "RoomDAMO2"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}