package com.sanmidev.themealdbcoroutines.features.meal

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.sanmidev.themealdbcoroutines.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.navArgs



@AndroidEntryPoint
class MealsFragment : Fragment() {

    private val args by navArgs<MealsFragmentArgs>()

    private val viewModel by viewModels<MealsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.meals_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}