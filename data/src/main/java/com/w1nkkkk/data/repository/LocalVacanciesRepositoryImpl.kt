package com.w1nkkkk.data.repository

import com.w1nkkkk.data.datasource.local.FavouritesLocalDatasource
import com.w1nkkkk.data.mapper.VacancyMapper
import com.w1nkkkk.domain.LocalVacanciesRepository
import com.w1nkkkk.domain.Vacancy

class LocalVacanciesRepositoryImpl(
    private val datasource: FavouritesLocalDatasource
) : LocalVacanciesRepository {

    private val mapper = VacancyMapper()

    override suspend fun insertVacancy(vacancy: Vacancy) {
        datasource.insertVacancy(mapper.mapToDboModel(vacancy))
    }

    override suspend fun deleteVacancy(vacancy: Vacancy) {
        datasource.deleteVacancy(mapper.mapToDboModel(vacancy))
    }

    override suspend fun getFavourites(): List<Vacancy> {
        return datasource.getFavourites().map { mapper.map(it) }
    }
}