package com.sanmidev.themealdbcoroutines.data.response.categories


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryResponse(
    @Json(name = "idCategory")
    val idCategory: String?,
    @Json(name = "strCategory")
    val strCategory: String?,
    @Json(name = "strCategoryDescription")
    val strCategoryDescription: String?,
    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String?
)