package com.ymir.fern_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.ymir.fern_app.ActivitySwitcher.switchToEvents
import com.ymir.fern_app.ActivitySwitcher.switchToMap
import com.ymir.fern_app.ActivitySwitcher.switchToProfileCreate

class ProfileActivity : AppCompatActivity() {

    private lateinit var mMapButton: Button
    private lateinit var mEventButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var person:Person = Person.getInstance()
        if (person.firstName == null || person.bio == null) { switchToProfileCreate(applicationContext)}
        else { fillDetails(person) }

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

    fun fillDetails(person: Person) {
        var txt: TextView

        txt = findViewById(R.id.profile_activity_first_name)
        txt.setText(person.firstName)

        txt = findViewById(R.id.profile_activity_last_name)
        txt.setText(person.secondName)

        txt = findViewById(R.id.profile_activity_uni)
        txt.setText(person.university)

        txt = findViewById(R.id.profile_activity_degree)
        txt.setText(person.degree)

        txt = findViewById(R.id.profile_activity_campus)
        txt.setText(person.campus)

        txt = findViewById(R.id.profile_activity_bio)
        txt.setText(person.bio)
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
        switchToProfileCreate(applicationContext)
    }
}
