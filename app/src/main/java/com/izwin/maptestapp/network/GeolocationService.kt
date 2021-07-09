package com.izwin.maptestapp.network

import com.izwin.maptestapp.model.RootModel
import retrofit2.http.GET

interface GeolocationService {
    @GET("russia.geo.json")
    suspend fun getGeolocations() : RootModel

}