package com.w1nkkkk.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.w1nkkkk.presentation.ControllerProvider
import com.w1nkkkk.presentation.Pluralize
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.adapters.FooterState
import com.w1nkkkk.presentation.adapters.VacanciesAdapter
import com.w1nkkkk.presentation.changeFragment
import com.w1nkkkk.presentation.databinding.FragmentFavouritesBinding
import com.w1nkkkk.presentation.pluralize
import com.w1nkkkk.presentation.viewmodels.FavouritesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class FavouritesFragment : Fragment() {

    private lateinit var binding: FragmentFavouritesBinding
    private val viewModel: FavouritesViewModel by inject()
    private val adapter : VacanciesAdapter = VacanciesAdapter(
        onIsFavoriteClick = {
            viewModel.deleteFavourites(it)
        },
        onNotFavoriteClick = {
            viewModel.deleteFavourites(it)
        },
        onCardClick = {
            val provider = activity as ControllerProvider
            provider.getController().navigate(R.id.action_favouritesFragment_to_plugFragment)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouritesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.favourites.collect {
                val list = it
                adapter.updateData(list, FooterState(false, {}, 0))
                binding.favouritesNum.text = "${list.size} ${list.size.pluralize(Pluralize.VacancyPluralize)}"
            }
        }
        binding.favouritesList.layoutManager = LinearLayoutManager(view.context)
        binding.favouritesList.adapter = adapter
    }

    companion object {
        fun newInstance() = FavouritesFragment()
    }
}