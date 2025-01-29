package com.w1nkkkk.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.w1nkkkk.domain.Offer
import com.w1nkkkk.presentation.OfferIconType
import com.w1nkkkk.presentation.R

class FastFiltersAdapter(
    private var filterList: List<Offer>
) : RecyclerView.Adapter<FastFiltersAdapter.FilterViewHolder>() {

    class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon : ImageView = itemView.findViewById(R.id.filterIcon)
        val name : TextView = itemView.findViewById(R.id.filterName)
        val button : TextView = itemView.findViewById(R.id.filterButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fast_filter_card, parent, false)
        return FilterViewHolder(view)
    }

    override fun getItemCount() = filterList.size

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val resId = filterList[position].id
        val image = if(resId != null) OfferIconType.valueOf(resId).icon else null
        if (image != null) holder.icon.setImageResource(image) else holder.icon.visibility = INVISIBLE
        holder.name.text = filterList[position].title
        val buttonText = filterList[position].buttonText
        if (buttonText != null) holder.button.text = buttonText else holder.button.visibility = INVISIBLE
    }

    fun setOperationList(newList : List<Offer>) {
        filterList = newList
        notifyDataSetChanged()
    }
}