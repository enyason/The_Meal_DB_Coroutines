package com.sanmidev.themealdbcoroutines.features.meal

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sanmidev.themealdbcoroutines.data.repo.MealsDBRepository

class MealsViewModel @ViewModelInject constructor(
    private val mealsDBRepository: MealsDBRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}