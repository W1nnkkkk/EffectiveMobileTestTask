package com.w1nkkkk.data.mapper

import com.w1nkkkk.data.entity.VacancyDboModel
import com.w1nkkkk.data.entity.VacancyDtoModel
import com.w1nkkkk.domain.Vacancy

class VacancyMapper {
    fun map(vacancy : VacancyDtoModel) : Vacancy {
        return Vacancy(
            lookingNumber = vacancy.lookingNumber ?: 0,
            title = vacancy.title,
            address = vacancy.address.town,
            company = vacancy.company,
            experience = vacancy.experience.previewText,
            publishedDate = vacancy.publishedDate,
            salary = vacancy.salary.full,
            isFavorite = vacancy.isFavorite
        )

    }

    fun map(vacancy : VacancyDboModel) : Vacancy {
        return Vacancy(
            lookingNumber = vacancy.lookingNumber,
            title = vacancy.title,
            address = vacancy.address,
            company = vacancy.company,
            experience = vacancy.experience,
            publishedDate = vacancy.publishedDate,
            salary = vacancy.salary,
            isFavorite = vacancy.isFavorite
        )
    }

    fun mapToDboModel(vacancy : Vacancy ) : VacancyDboModel {
        return VacancyDboModel(
            id = 0,
            lookingNumber = vacancy.lookingNumber,
            title = vacancy.title,
            address = vacancy.address,
            company = vacancy.company,
            experience = vacancy.experience,
            publishedDate = vacancy.publishedDate,
            salary = vacancy.salary,
            isFavorite = vacancy.isFavorite
        )
    }
}