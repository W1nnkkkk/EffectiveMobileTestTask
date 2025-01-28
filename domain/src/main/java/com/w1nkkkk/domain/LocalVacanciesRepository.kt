package com.w1nkkkk.domain

interface LocalVacanciesRepository {
    suspend fun insertVacancy(vacancy: Vacancy)
    suspend fun deleteVacancy(vacancy: Vacancy)
    suspend fun getFavourites() : List<Vacancy>
}