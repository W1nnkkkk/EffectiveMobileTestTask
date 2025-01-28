package com.w1nkkkk.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.w1nkkkk.data.entity.VacancyDboModel

@Database(entities = [VacancyDboModel::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {

    abstract fun getDao() : FavouritesDao

    companion object {
        private var INSTANCE : FavouritesDatabase? = null

        fun getInstance(context: Context) : FavouritesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instace = Room.databaseBuilder(context,
                    FavouritesDatabase::class.java,
                    "favourites_db"
                ).build()
                INSTANCE = instace
                instace
            }
        }
    }
}