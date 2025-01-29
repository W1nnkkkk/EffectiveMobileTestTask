package com.w1nkkkk.presentation.adapters

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.w1nkkkk.domain.Vacancy

class VacanciesAdapter : ListDelegationAdapter<List<ListItem>>() {
    init {
        delegatesManager
            .addDelegate(VacancyDelegate())
            .addDelegate(FooterDelegate())
    }

    fun updateData(vacancies: List<Vacancy>, footerState: FooterState) {
        val items = vacancies.map { ListItem.VacancyItem(it) } +
                ListItem.FooterItem(footerState.copy(itemCount = vacancies.size))
        setItems(items)
        notifyDataSetChanged()
    }
}