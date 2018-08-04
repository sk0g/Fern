package com.ymir.fern_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProfileActivity : AppCompatActivity() {

    lateinit var mMapsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mMapsButton = findViewById(R.id.activity_profile_maps_button)
        mMapsButton.setOnClickListener {view ->
            switchToMap(view)
        }
    }

    fun switchToMap(view: View) {
        val intent = Intent(applicationContext, MapsActivity::class.java)
        startActivity(intent)
    }
}
