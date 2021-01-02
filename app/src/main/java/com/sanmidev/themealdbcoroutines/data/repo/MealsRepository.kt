package com.sanmidev.themealdbcoroutines.data.repo

import com.sanmidev.themealdbcoroutines.data.model.category.CategoryModel
import com.sanmidev.themealdbcoroutines.data.model.meal.MealModel

interface MealsRepository {
    suspend fun getCategories() : List<CategoryModel>

    suspend fun getMeal(name : String) : List<MealModel>
}