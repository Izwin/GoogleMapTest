package com.izwin.maptestapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izwin.maptestapp.model.RootModel
import com.izwin.maptestapp.network.GeolocationsRetrofitClient
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MapsViewModel : ViewModel() {
    private val client = GeolocationsRetrofitClient.create()
    val locations = MutableLiveData<RootModel>()

    fun getGeolocations(){
        runBlocking {
            async { locations.postValue(client!!.getGeolocations())}.await()
        }
    }
}