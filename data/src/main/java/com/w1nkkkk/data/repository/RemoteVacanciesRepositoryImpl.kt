package com.w1nkkkk.data.repository

import com.w1nkkkk.data.datasource.remote.RemoteDatasource
import com.w1nkkkk.data.mapper.OfferMapper
import com.w1nkkkk.data.mapper.VacancyMapper
import com.w1nkkkk.domain.Offer
import com.w1nkkkk.domain.RemoteVacanciesRepository
import com.w1nkkkk.domain.Vacancy

class RemoteVacanciesRepositoryImpl(
    private val remoteDatasource: RemoteDatasource
) : RemoteVacanciesRepository {

    private val offerMapper = OfferMapper()
    private val vacancyMapper = VacancyMapper()

    override suspend fun getData(): Pair<List<Offer>, List<Vacancy>> {
        val data = remoteDatasource.getData()
        return Pair(data.offers.map { offerMapper.map(it) }, data.vacancies.map { vacancyMapper.map(it) })
    }
}