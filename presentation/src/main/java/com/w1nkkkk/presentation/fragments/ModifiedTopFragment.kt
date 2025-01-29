package com.w1nkkkk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.w1nkkkk.presentation.Pluralize
import com.w1nkkkk.presentation.R
import com.w1nkkkk.presentation.changeFragment
import com.w1nkkkk.presentation.databinding.FragmentModifiedTopBinding
import com.w1nkkkk.presentation.pluralize
import com.w1nkkkk.presentation.viewmodels.VacanciesViewModel
import org.koin.android.ext.android.inject

class ModifiedTopFragment : Fragment() {

    lateinit var binding: FragmentModifiedTopBinding
    private val viewModel : VacanciesViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModifiedTopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vacancyCount = viewModel.state.value?.vacancies?.size
        if (vacancyCount != null) {
            binding.vacaytionsNum.text = "$vacancyCount ${vacancyCount!!.pluralize(Pluralize.VacancyPluralize)}"
        }
        binding.backButton.setOnClickListener {
            changeFragment(R.id.topFrame, BaseTopFragment.newInstance())
            changeFragment(R.id.vacancyFrame, VacanciesListFragment.newInstance())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ModifiedTopFragment()
    }
}