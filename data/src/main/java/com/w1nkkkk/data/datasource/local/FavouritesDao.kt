package com.w1nkkkk.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.w1nkkkk.data.entity.VacancyDboModel

@Dao
interface FavouritesDao {
    @Insert
    fun insertVacancy(vacancyDboModel: VacancyDboModel)

    @Delete
    fun deleteVacancy(vacancyDboModel: VacancyDboModel)

    @Query("SELECT * FROM vacancies")
    fun getFavourites() : List<VacancyDboModel>
}