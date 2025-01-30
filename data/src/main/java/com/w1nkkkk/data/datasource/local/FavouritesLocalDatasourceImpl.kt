package com.w1nkkkk.data.datasource.local

import android.content.Context
import android.util.Log
import com.w1nkkkk.data.entity.VacancyDboModel

class FavouritesLocalDatasourceImpl(
    private val context: Context
) : FavouritesLocalDatasource {

    private val dao = FavouritesDatabase.getInstance(context).getDao()

    override suspend fun insertVacancy(vacancyDboModel: VacancyDboModel) {
        dao.insertVacancy(vacancyDboModel)
    }

    override suspend fun deleteVacancy(vacancyDboModel: VacancyDboModel) {
        dao.deleteVacancy(vacancyDboModel)
    }

    override suspend fun getFavourites(): List<VacancyDboModel> {
        return dao.getFavourites()
    }
}