package com.sanmidev.themealdbcoroutines.data.repo

import com.sanmidev.themealdbcoroutines.data.MealsDbService
import com.sanmidev.themealdbcoroutines.data.model.CategoryModel
import com.sanmidev.themealdbcoroutines.data.response.mapper.MealsDbMapper

class MealsDBRepository(private val mealsDbService: MealsDbService, private val mapper : MealsDbMapper) : MealsRepository {
    override suspend fun getCategories(): List<CategoryModel> {
       return mealsDbService.getCategories().categories.map { mapper.mapCategoryResponseToModel(it) }
    }
}