package com.example.mercadolibreapp

import androidx.lifecycle.ViewModel
import com.example.models.ProductListWeb
import com.example.networking.MercadoLibreEndpoints
import com.example.networking.RetrofitClient

class MainViewModel: ViewModel() {

    val service = RetrofitClient.buildService(MercadoLibreEndpoints::class.java)
    var query = ""

    suspend fun getSearchResult(): ProductListWeb?{
        val result = service.getProductsByName(query)
        return result.body()
    }

    /*fun getSearchResultNotSuspend(){
        isBusy.postValue(true)
        service.getProductsByNameNotSuspend(query).enqueue(object: Callback<ProductListWeb>{
            override fun onFailure(call: Call<ProductListWeb>, t: Throwable) {
                result.postValue(null)
                isBusy.postValue(false)
            }

            override fun onResponse(call: Call<ProductListWeb>, response: Response<ProductListWeb>) {
                result.postValue(response.body())
                isBusy.postValue(false)
            }
        })
    }*/

}