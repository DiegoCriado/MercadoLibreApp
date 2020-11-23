package com.example.networking

import com.example.models.ProductListWeb
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MercadoLibreEndpoints {

    @GET("search")
    suspend fun getProductsByName(@Query("q") productName : String): Response<ProductListWeb>

   /* @GET("search")
    fun getProductsByNameNotSuspend(@Query("q") productName : String): Call<ProductListWeb>
    */
}