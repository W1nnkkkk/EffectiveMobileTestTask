package com.w1nkkkk.data.datasource.local


import com.w1nkkkk.data.entity.VacancyDboModel

interface FavouritesLocalDatasource {
    suspend fun insertVacancy(vacancyDboModel: VacancyDboModel)
    suspend fun deleteVacancy(vacancyDboModel: VacancyDboModel)
    suspend fun getFavourites() : List<VacancyDboModel>
}