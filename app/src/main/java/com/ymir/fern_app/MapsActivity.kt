package com.ymir.fern_app

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.PlaceDetectionClient
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var mMapButton: Button
    lateinit var mProfileButton: Button

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
            switchToProfile(view)
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

        while (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Resistance is futile. Accept.", Toast.LENGTH_SHORT).show()
            requestLocationPermission()
        }

        mMap.isMyLocationEnabled = true

        moveToCurrentLocation()

        // TODO: Draw all surrounding events/ people.
        // TODO: Toggle for distance ranges. Maybe?
    }

    fun moveToCurrentLocation() {
        try {
            var myLocation = mLocationProvider.lastLocation.addOnSuccessListener { location: Location ->
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
                13.0f
            )
        )
    }

    fun requestLocationPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                RECORD_REQUEST_CODE)
    }

    fun switchToProfile(view: View) {
        val intent = Intent(applicationContext, ProfileActivity::class.java)
        startActivity(intent)
    }
}
