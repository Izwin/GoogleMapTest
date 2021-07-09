package com.izwin.maptestapp.utill

import android.graphics.Color
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.SphericalUtil

class DirectRouteBuilder : RouteBuilder() {
    var polyline: Polyline? = null

    override fun buildRoute(map: GoogleMap, list: List<LatLng>) {
        polyline?.remove()
        val polylineOptions = PolylineOptions().addAll(list).color(Color.BLUE).width(1f).geodesic(true)
        polyline = map.addPolyline(polylineOptions)
    }

    override fun calculateDistance(map: GoogleMap, list: List<LatLng>): Double {
        var km = 0.0
        for (i in 0..list.size - 2){
            km += calculateDistanceBetweenTwoPoints(list[i], list[i + 1])
        }
        return km
    }

    private fun calculateDistanceBetweenTwoPoints(start: LatLng, end: LatLng): Double {
        val distance =  SphericalUtil.computeDistanceBetween(start , end)

        return distance/1000
    }


}