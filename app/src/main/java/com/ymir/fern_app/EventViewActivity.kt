package com.ymir.fern_app

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ymir.fern_app.ActivitySwitcher.switchToMap
import com.ymir.fern_app.ActivitySwitcher.switchToProfile

class EventViewActivity : AppCompatActivity() {

    lateinit var mMapButton: Button
    lateinit var mProfileButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_view)

        mMapButton = findViewById(R.id.activity_events_map_button)
        mMapButton.setOnClickListener { view ->
            switchToMap(applicationContext, view)
        }

        mProfileButton = findViewById(R.id.activity_events_profile_button)
        mProfileButton.setOnClickListener { view ->
            switchToProfile(applicationContext, view)
        }
    }

}
