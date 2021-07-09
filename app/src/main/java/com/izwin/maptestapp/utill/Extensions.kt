package com.izwin.maptestapp.utill

import com.google.android.gms.maps.model.LatLng

object Extensions {
     fun convertDoubleToLatLng(doubleList: List<List<List<List<Double>>>>): List<LatLng> {
         val latLngList = ArrayList<LatLng>()
         for (geoGroups in doubleList) {
             for (geo in geoGroups[0]) {

                 var lat = geo[0]
                 var lon = geo[1]

                 ///// Тут я сделал проверку на выход за границы, так как в ответе с сервера очень много точек которые выходят за границы(без этой проверки маршрут заполняет почти весь экран)
                 if (lat > 80 || lat < -80) continue
                 if (lon > 80 || lon < -80) continue

                 latLngList.add(LatLng(lat, lon))
             }

         }
         return latLngList
     }
}