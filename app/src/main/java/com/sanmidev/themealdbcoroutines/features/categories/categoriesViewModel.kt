package com.sanmidev.themealdbcoroutines.features.meals.categories

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanmidev.themealdbcoroutines.R
import com.sanmidev.themealdbcoroutines.data.model.CategoryModel
import com.sanmidev.themealdbcoroutines.data.repo.MealsRepository
import com.sanmidev.themealdbcoroutines.utils.NetworkState
import com.sanmidev.themealdbcoroutines.utils.runOnMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class CategoriesViewModel @ViewModelInject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {

    private val _getCategoriesNetworkState =
        MutableStateFlow<NetworkState<List<CategoryModel>>>(NetworkState.Loading)
    val getCategoriesNetworkState
        get() = _getCategoriesNetworkState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            runOnMain {
                _getCategoriesNetworkState.value = NetworkState.Loading
            }

            try {
                val response = mealsRepository.getCategories()

                runOnMain {
                    _getCategoriesNetworkState.value = NetworkState.Success(response)
                }
            } catch (ex: IOException) {
                runOnMain {
                    _getCategoriesNetworkState.value =
                        NetworkState.Error(R.string.get_catogories_error, ex)
                }
            }
        }
    }
}