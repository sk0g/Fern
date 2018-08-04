package com.ymir.fern_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var mMapsButton: Button
    lateinit var mProfileButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMapsButton = findViewById(R.id.activity_main_map_button)
        mMapsButton.setOnClickListener {view ->
            switchToMap(view)
        }

        mProfileButton = findViewById(R.id.activity_main_profile_button)
        mProfileButton.setOnClickListener {view ->
            switchToProfile(view)
        }
    }

    fun switchToMap(view: View) {
        val intent = Intent(applicationContext, MapsActivity::class.java)
        startActivity(intent)
    }

    fun switchToProfile(view: View) {
        val intent = Intent(applicationContext, ProfileActivity::class.java)
        startActivity(intent)
    }
}
