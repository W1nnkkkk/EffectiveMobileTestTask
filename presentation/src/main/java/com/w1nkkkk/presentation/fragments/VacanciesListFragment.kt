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
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.adapters.FooterState
import com.w1nkkkk.presentation.adapters.VacanciesAdapter
import com.w1nkkkk.presentation.changeFragment
import com.w1nkkkk.presentation.databinding.FragmentVacanciesListBinding
import com.w1nkkkk.presentation.viewmodels.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VacanciesListFragment : Fragment() {

    private lateinit var binding : FragmentVacanciesListBinding
    private val viewModel: VacanciesViewModel by viewModel()
    private val adapter : VacanciesAdapter = VacanciesAdapter()
    private var fullVacancyList : List<Vacancy> = emptyList()
    var footerState = FooterState(true, {})

    private fun onFooterButtonClick(view: View) {
        changeFragment(R.id.topFrame, ModifiedTopFragment.newInstance())
        footerState = FooterState(false, {})
        adapter.updateData(fullVacancyList, footerState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this as LifecycleOwner) {
            when(it) {
                is VacanciesViewModel.State.Error -> {}
                is VacanciesViewModel.State.Success -> {
                    fullVacancyList = it.vacancies
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
        footerState = FooterState(true, ::onFooterButtonClick)
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