package com.izwin.maptestapp.utill

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng

abstract class RouteBuilder() {
    abstract fun buildRoute(map: GoogleMap, list: List<LatLng>)
    abstract fun calculateDistance(map: GoogleMap, list: List<LatLng>): Double
}