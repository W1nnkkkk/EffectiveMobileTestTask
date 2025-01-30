package com.w1nkkkk.presentation.adapters

import android.view.View
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.w1nkkkk.domain.Vacancy

class VacanciesAdapter(
    private val onIsFavoriteClick: (Vacancy) -> Unit = {},
    private val onNotFavoriteClick: (Vacancy) -> Unit = {},
    private val onCardClick: (View) -> Unit = {}
) : ListDelegationAdapter<List<ListItem>>() {
    init {
        delegatesManager
            .addDelegate(VacancyDelegate(onIsFavoriteClick, onNotFavoriteClick, onCardClick))
            .addDelegate(FooterDelegate())
    }

    fun updateData(vacancies: List<Vacancy>, footerState: FooterState) {
        var itemsCount = footerState.itemCount - 3
        if (itemsCount < 1) {
            itemsCount = 0
        }
        val items = vacancies.map { ListItem.VacancyItem(it) } +
                ListItem.FooterItem(footerState.copy(itemCount = itemsCount))
        setItems(items)
        notifyDataSetChanged()
    }
}