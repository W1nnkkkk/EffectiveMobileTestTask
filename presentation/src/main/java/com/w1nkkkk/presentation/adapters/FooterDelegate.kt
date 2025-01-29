package com.w1nkkkk.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.w1nkkkk.presentation.Pluralize
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.pluralize

class FooterDelegate : AdapterDelegate<List<ListItem>>() {
    override fun isForViewType(items: List<ListItem>, position: Int): Boolean =
        items[position] is ListItem.FooterItem

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.footer_button, parent, false)
        return FooterViewHolder(view)
    }

    override fun onBindViewHolder(
        items: List<ListItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position] as ListItem.FooterItem
        (holder as FooterViewHolder).bind(item.state)
    }

    class FooterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(state: FooterState) {
            val button = view.findViewById<Button>(R.id.manyVacations)
            if (state.visible) {
                button.visibility = View.VISIBLE
                button.setOnClickListener(state.onClick)
                val text = "Еще ${state.itemCount} ${state.itemCount.pluralize(Pluralize.VacancyPluralize)}"
                button.text = text
            } else {
                button.visibility = View.INVISIBLE
            }
        }
    }
}