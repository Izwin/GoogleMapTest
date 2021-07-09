package com.izwin.maptestapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.izwin.maptestapp.R
import com.izwin.maptestapp.databinding.ActivityMapsBinding
import com.izwin.maptestapp.utill.DirectRouteBuilder
import com.izwin.maptestapp.utill.Extensions.convertDoubleToLatLng
import com.izwin.maptestapp.utill.RouteBuilder
import com.izwin.maptestapp.viewmodel.MapsViewModel
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private val viewModel by viewModels<MapsViewModel>()
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var routeBuilder: RouteBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        routeBuilder = DirectRouteBuilder()

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        viewModel.getGeolocations()

        viewModel.locations.observe(this) {
            val doubleList = it!!.features!![0].geometry!!.coordinates!!
            val list = convertDoubleToLatLng(doubleList)

            /// Добавление маркеров
            for (latLng in list){
                mMap.addMarker(MarkerOptions().position(latLng).title("${latLng.latitude};${latLng.longitude}"))
            }

            ///Отрисовка пути и вывод дистанции
            routeBuilder.buildRoute(mMap, list)
            distanceText.text = routeBuilder.calculateDistance(mMap, list).toString()

        }

    }

}