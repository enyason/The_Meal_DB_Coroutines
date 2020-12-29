package com.sanmidev.themealdbcoroutines.data.response.mapper

import com.sanmidev.themealdbcoroutines.data.model.CategoryModel
import com.sanmidev.themealdbcoroutines.data.response.categories.CategoryResponse

object MealsDbMapper {

    fun mapCategoryResponseToModel(categoryResponse: CategoryResponse): CategoryModel {
        return with(categoryResponse) {
            CategoryModel(
                this.idCategory ?: "",
                this.strCategory ?: "",
                this.strCategoryDescription ?: "",
                this.strCategoryThumb ?: ""
            )
        }
    }
}