package com.w1nkkkk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.changeFragment
import com.w1nkkkk.presentation.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeFragment(binding.topFrame.id, BaseTopFragment())
        changeFragment(binding.vacancyFrame.id, VacanciesListFragment())
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}