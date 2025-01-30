package com.w1nkkkk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.w1nkkkk.presentation.adapters.FastFiltersAdapter
import com.w1nkkkk.presentation.databinding.FragmentBaseTopBinding
import com.w1nkkkk.presentation.viewmodels.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaseTopFragment : Fragment() {

    private lateinit var binding: FragmentBaseTopBinding
    private val adapter : FastFiltersAdapter = FastFiltersAdapter(emptyList())
    val viewModel: VacanciesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this as LifecycleOwner) {
            when (it) {
                is VacanciesViewModel.State.Error -> {}
                is VacanciesViewModel.State.Success -> {
                    adapter.setOperationList(it.offers)
                    binding.fastFilters.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseTopBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (adapter.itemCount == 0) {
            binding.fastFilters.visibility = View.GONE
        }
        binding.fastFilters.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.fastFilters.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = BaseTopFragment()

    }
}