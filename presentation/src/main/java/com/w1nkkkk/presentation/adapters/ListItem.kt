package com.w1nkkkk.presentation.adapters

import android.view.View
import com.w1nkkkk.domain.Vacancy

data class FooterState(val visible: Boolean, val onClick: (View) -> Unit, val itemCount : Int)

sealed class ListItem {
    data class VacancyItem(val vacancy: Vacancy) : ListItem()
    data class FooterItem(val state: FooterState) : ListItem()
}