package com.w1nkkkk.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.w1nkkkk.presentation.R

class FavouritesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    companion object {
        private var INSTANCE : FavouritesFragment? = null
        fun newInstance() : FavouritesFragment {
            return INSTANCE ?: synchronized(this) {
                val inst = FavouritesFragment()
                INSTANCE = inst
                inst
            }
        }
    }
}