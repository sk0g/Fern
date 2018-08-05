package com.ymir.fern_app

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.ymir.fern_app.ActivitySwitcher.switchToEvents
import com.ymir.fern_app.ActivitySwitcher.switchToProfile

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var mMapButton: Button
    lateinit var mProfileButton: Button
    lateinit var mEventsButton: Button

    private lateinit var mMap: GoogleMap
    private val RECORD_REQUEST_CODE = 101
    private lateinit var mLocationProvider: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        mMapButton = findViewById(R.id.activity_maps_maps_button)
        mMapButton.setOnClickListener {view ->
            moveToCurrentLocation()
        }

        mProfileButton = findViewById(R.id.activity_maps_profile_button)
        mProfileButton.setOnClickListener {view ->
            switchToProfile(applicationContext, view)
        }

        mEventsButton = findViewById(R.id.activity_maps_events_button)
        mEventsButton.setOnClickListener {view ->
            switchToEvents(applicationContext, view)
        }

        mLocationProvider = LocationServices.getFusedLocationProviderClient(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.night_mode))

        while (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission()
        }

        mMap.isMyLocationEnabled = true

        moveToCurrentLocation()

        // TODO: Draw all surrounding events/ people.
        // TODO: Toggle for distance ranges. Maybe?

        for (marker in getMarkers()) {
            markOnMap(marker)
        }
    }


    fun moveToCurrentLocation() {
        try {
            mLocationProvider.lastLocation.addOnSuccessListener { location: Location ->
                moveToLocation(location)
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message)
        }
    }

    fun moveToLocation(mKnownLocation: Location) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                LatLng(mKnownLocation.latitude,
                       mKnownLocation.longitude),
                16.0f
            )
        )
    }

    fun requestLocationPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                RECORD_REQUEST_CODE)
    }

    fun markOnMap(marker: CustomMarker) {
        val icon: Int = if (marker.isPerson) {
            R.drawable.avatar_icon
        } else {
            R.drawable.calendar_icon
        }

        mMap.addMarker(MarkerOptions()
                .position(LatLng(marker.lat, marker.long))
                .title(marker.description)
                .alpha(100f))
                .setIcon(BitmapDescriptorFactory.fromResource(icon))
    }

    fun getMarkers(): ArrayList<CustomMarker> {
        // TODO: Return surrounding markers from Database
        // for now, dummy data is returned to test drawing functionality

        val list = arrayListOf<CustomMarker>(
            CustomMarker(false,  -27.9595, 153.3814, "Rad party at uni hospital"),
            CustomMarker(true, -27.9620592, 153.3778157, "Bored at library :("), 
            CustomMarker(false, -27.962996, 153.381125, "Omg exam tomorrow pls help"), 
            CustomMarker(true, -27.961156, 153.380912, "Exam tomorrow. Haven't studied. Anyone need a drinking partner?"), 
            CustomMarker(false, -27.963354, 153.383775, "LAN Party, ICT Students only"),
            CustomMarker(false, -27.962177, 153.380284, "Yoga & Tai-Chi outside uni library"), 
            CustomMarker(true, -27.963660, 153.383009, "Arrays start at 1 right1//1?!?!?!?"),
            CustomMarker(false, -27.963138, 153.382828, "Comp Sci catch up before 1806ICT culls over half our student base yeet")
        )

        return list
    }
}

data class CustomMarker(val isPerson: Boolean, val lat: Double, val long: Double, val description: String)
