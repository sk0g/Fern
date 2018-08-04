package com.ymir.fern_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.ymir.fern_app.ActivitySwitcher.switchToMap

class ProfileActivity : AppCompatActivity() {

    private lateinit var mMapButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mMapButton = findViewById(R.id.activity_profile_maps_button)
        mMapButton.setOnClickListener {view ->
            switchToMap(applicationContext, view) }
    }
}
