package com.w1nkkkk.domain

interface RemoteVacanciesRepository {
    suspend fun getData() : Pair<List<Offer>, List<Vacancy>>
}