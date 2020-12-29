package com.sanmidev.themealdbcoroutines.data.repo

import com.sanmidev.themealdbcoroutines.data.model.CategoryModel

interface MealsRepository {
    suspend fun getCategories() : List<CategoryModel>
}