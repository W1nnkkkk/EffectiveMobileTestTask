package com.w1nkkkk.presentation.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class CustomFragmentFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            SearchFragment::class.java.name -> { SearchFragment.newInstance() }
            BaseTopFragment::class.java.name -> { BaseTopFragment.newInstance() }
            VacanciesListFragment::class.java.name -> { VacanciesListFragment.newInstance() }
            ModifiedTopFragment::class.java.name -> { ModifiedTopFragment.newInstance() }
            else -> super.instantiate(classLoader, className)
        }
    }
}