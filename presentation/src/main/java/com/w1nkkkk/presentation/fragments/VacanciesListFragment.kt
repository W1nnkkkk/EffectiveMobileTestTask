package com.w1nkkkk.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.w1nkkkk.domain.Vacancy
import com.w1nkkkk.presentation.ControllerProvider
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.adapters.FooterState
import com.w1nkkkk.presentation.adapters.VacanciesAdapter
import com.w1nkkkk.presentation.changeFragment
import com.w1nkkkk.presentation.databinding.FragmentVacanciesListBinding
import com.w1nkkkk.presentation.viewmodels.FavouritesViewModel
import com.w1nkkkk.presentation.viewmodels.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VacanciesListFragment : Fragment() {

    private lateinit var binding : FragmentVacanciesListBinding
    private val viewModel: VacanciesViewModel by viewModel()
    private val favouritesViewModel : FavouritesViewModel by viewModel()
    private val adapter : VacanciesAdapter = VacanciesAdapter(
        onIsFavoriteClick = {
            favouritesViewModel.deleteFavourites(it)
        },
        onNotFavoriteClick = {
            favouritesViewModel.insertFavourites(it)
        },
        onCardClick = {
            val provider = activity as ControllerProvider
            provider.getController().navigate(R.id.action_searchFragment_to_plugFragment)
        }
    )
    private var fullVacancyList : List<Vacancy> = emptyList()
    private var footerState = FooterState(true, {}, fullVacancyList.size)

    private fun onFooterButtonClick(view: View) {
        changeFragment(R.id.topFrame, ModifiedTopFragment.newInstance())
        footerState = FooterState(false, {}, fullVacancyList.size)
        adapter.updateData(fullVacancyList, footerState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this as LifecycleOwner) {
            when(it) {
                is VacanciesViewModel.State.Error -> {}
                is VacanciesViewModel.State.Success -> {
                    fullVacancyList = it.vacancies
                    footerState = FooterState(true, ::onFooterButtonClick, fullVacancyList.size)
                    adapter.updateData(fullVacancyList.subList(0, 3), footerState)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVacanciesListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        footerState = FooterState(true, ::onFooterButtonClick, fullVacancyList.size)
        try { adapter.updateData(fullVacancyList.subList(0, 3), footerState) }
        catch (_: Throwable) { adapter.updateData(emptyList(), footerState) }
        binding.vacancyRecyclerView.layoutManager = LinearLayoutManager(view.context)
        binding.vacancyRecyclerView.adapter = adapter
    }


    companion object {
        @JvmStatic
        fun newInstance() = VacanciesListFragment()
    }
}