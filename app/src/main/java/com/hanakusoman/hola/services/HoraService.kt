package com.hanakusoman.hola.services

import com.hanakusoman.hola.models.Category
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by taihe on 2017/10/25.
 */
interface HoraService {
    // https://firebasestorage.googleapis.com/v0/b/hora-26ff4.appspot.com/o/categories.json?alt=media&token=c971f643-027d-4845-bca4-aa2f68d66ce4
    // https://firebasestorage.googleapis.com/v0/b/hora-26ff4.appspot.com/o/categories.json?alt=media&token=483e7276-ab71-4b66-91a8-0c2a08e5cd48
    // https://firebasestorage.googleapis.com/v0/b/hora-26ff4.appspot.com/o/categories.json?alt=media&token=e4a7d880-2bcd-4009-857a-f6b969bd78cb
    // https://firebasestorage.googleapis.com/v0/b/hora-26ff4.appspot.com/o/categories.json?alt=media&token=e4a7d880-2bcd-4009-857a-f6b969bd78cb
    @GET("/v0/b/hora-26ff4.appspot.com/o/categories.json?alt=media&token=c971f643-027d-4845-bca4-aa2f68d66ce4")
    fun getCategories(): Call<List<Category>>

}

class HoraServiceGenerator {
    companion object {
        fun createService(): HoraService {
            val apiUrl = "https://firebasestorage.googleapis.com"
            val retrofit = Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(HoraService::class.java)
        }
    }
}