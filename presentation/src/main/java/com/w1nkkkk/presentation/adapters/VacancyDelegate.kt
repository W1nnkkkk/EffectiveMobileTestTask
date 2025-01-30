package com.w1nkkkk.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.w1nkkkk.domain.Vacancy
import com.w1nkkkk.presentation.Pluralize
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.formatDate
import com.w1nkkkk.presentation.pluralize
import kotlin.properties.Delegates

class VacancyDelegate(
    private val onIsFavoriteClick: (Vacancy) -> Unit = {},
    private val onNotFavoriteClick: (Vacancy) -> Unit = {},
    private val onCardClick: (View) -> Unit = {}
) : AdapterDelegate<List<ListItem>>() {
    override fun isForViewType(items: List<ListItem>, position: Int): Boolean =
        items[position] is ListItem.VacancyItem

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vacancies_list_element, parent, false)
        return VacancyViewHolder(view)
    }

    override fun onBindViewHolder(
        items: List<ListItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        itemCount = items.size
        val item = items[position] as ListItem.VacancyItem
        (holder as VacancyViewHolder).bind(item.vacancy)
    }

    var itemCount : Int = 0

    inner class VacancyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(vacancy: Vacancy) {
            val vacancyCard = view.findViewById<CardView>(R.id.vacancyCard)
            vacancyCard.setOnClickListener(onCardClick)
            if (vacancy.lookingNumber == 0) {
                lookingNumber.visibility = View.GONE
            }
            lookingNumber.text = "Сейчас просматривает ${vacancy.lookingNumber} ${vacancy.lookingNumber.pluralize(Pluralize.HumanPluralize)}"
            vacancyName.text = vacancy.title
            salary.text = vacancy.salary
            vacancyCity.text = vacancy.address
            companyName.text = vacancy.company
            vacancyExperience.text = vacancy.experience
            publishDate.text = vacancy.publishedDate.formatDate()
            fav = vacancy.isFavorite
            if (vacancy.isFavorite) {
                isFavorite.setImageResource(R.drawable.full_blue_favorite_icon)
                isFavorite.setColorFilter(view.context.getColor(R.color.favorite_icon_color))
            }
            else {
                isFavorite.setImageResource(R.drawable.ffvorite_border_ic)
                isFavorite.setColorFilter(view.context.getColor(R.color.not_favorite_icon_color))
            }
            isFavorite.setOnClickListener {
                vacancy.isFavorite = !vacancy.isFavorite
                onFavoriteClick(vacancy)
            }
        }

        val lookingNumber : TextView = view.findViewById(R.id.lookingNumber)
        val vacancyName : TextView = view.findViewById(R.id.vacancyName)
        val salary : TextView = view.findViewById(R.id.salary)
        val vacancyCity : TextView = view.findViewById(R.id.vacancyCity)
        val companyName : TextView = view.findViewById(R.id.companyName)
        val vacancyExperience : TextView = view.findViewById(R.id.vacancyExperience)
        val publishDate : TextView = view.findViewById(R.id.publishDate)
        val respond: Button = view.findViewById(R.id.respond)
        val isFavorite: ImageButton = view.findViewById(R.id.isFavorite)

        private var fav by Delegates.notNull<Boolean>()

        private fun onFavoriteClick(vacancy: Vacancy) {
            if (!fav) {
                isFavorite.setImageResource(R.drawable.full_blue_favorite_icon)
                isFavorite.setColorFilter(view.context.getColor(R.color.favorite_icon_color))
                fav = true
                onNotFavoriteClick(vacancy)
            } else {
                isFavorite.setImageResource(R.drawable.ffvorite_border_ic)
                isFavorite.setColorFilter(view.context.getColor(R.color.not_favorite_icon_color))
                fav = false
                onIsFavoriteClick(vacancy)
            }
        }
    }
}