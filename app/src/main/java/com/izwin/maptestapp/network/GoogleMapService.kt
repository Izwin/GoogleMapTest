package com.izwin.maptestapp.network

import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleMapService {
    @GET("directions/json")
    suspend fun getRoute(@Query("origin") origin: String, @Query("mode") mode: String , @Query("destination") destination: String, @Query("key") key: String)
}