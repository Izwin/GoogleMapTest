package com.izwin.maptestapp.utill

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.izwin.maptestapp.network.GoogleMapRetrofitClient
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class DrivingRouteBuilder: RouteBuilder() {
    override fun buildRoute(map: GoogleMap, list: List<LatLng>) {
        // Я пытался так же сделать вариант с автомобильным маршрутом, но для этого нужно использовать платный API
    }

    override fun calculateDistance(
        map: GoogleMap,
        list: List<LatLng>
    ): Double {
        return 0.0
    }
}