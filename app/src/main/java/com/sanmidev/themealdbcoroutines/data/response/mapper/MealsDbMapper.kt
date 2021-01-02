package com.sanmidev.themealdbcoroutines.data.response.mapper

import com.sanmidev.themealdbcoroutines.data.model.category.CategoryModel
import com.sanmidev.themealdbcoroutines.data.model.meal.MealModel
import com.sanmidev.themealdbcoroutines.data.response.categories.CategoryResponse
import com.sanmidev.themealdbcoroutines.data.response.meal.MealResponse

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

    fun mapMealResponseToModel(mealResponse: MealResponse) : MealModel {
        return  with(mealResponse){
            MealModel(idMeal ?: "", strMeal ?: "", strMealThumb ?: "" )
        }
    }

}