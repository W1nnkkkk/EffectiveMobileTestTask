package com.w1nkkkk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.viewmodels.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VacanciesListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vacancies_list, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            VacanciesListFragment().apply {}
    }
}