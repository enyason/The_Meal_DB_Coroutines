package com.sanmidev.themealdbcoroutines.data

import com.sanmidev.themealdbcoroutines.data.response.categories.CategoriesResponse
import retrofit2.http.GET

interface MealsDbService {

    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories() : CategoriesResponse
}