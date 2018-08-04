package com.ymir.fern_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.ymir.fern_app.ActivitySwitcher.switchToEvents
import com.ymir.fern_app.ActivitySwitcher.switchToMap

class ProfileActivity : AppCompatActivity() {

    private lateinit var mMapButton: Button
    private lateinit var mEventButton: Button
    private lateinit var mEditProfileButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mMapButton = findViewById(R.id.activity_profile_maps_button)
        mMapButton.setOnClickListener {view ->
            switchToMap(applicationContext, view)
        }

        mEventButton = findViewById(R.id.activity_profile_events_button)
        mEventButton.setOnClickListener {view ->
            switchToEvents(applicationContext, view)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId

        if (id == R.id.activity_profile_edit_text) {
            editProfile()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun editProfile() {
        return
    }
}
