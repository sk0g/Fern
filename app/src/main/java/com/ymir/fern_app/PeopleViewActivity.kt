package com.ymir.fern_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ListView
import com.ymir.fern_app.ActivitySwitcher.switchToMap
import com.ymir.fern_app.ActivitySwitcher.switchToProfile

class PeopleViewActivity : AppCompatActivity() {

    lateinit var mMapButton: Button
    lateinit var mProfileButton: Button
    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_view)

        mMapButton = findViewById(R.id.activity_people_map_button)
        mMapButton.setOnClickListener { view ->
            switchToMap(applicationContext, view)
        }

        mProfileButton = findViewById(R.id.activity_people_profile_button)
        mProfileButton.setOnClickListener { view ->
            switchToProfile(applicationContext, view)
        }

        listview = findViewById(R.id.people_list_view)

        val events = getEventArray()

        val adapter = PeopleAdapter(this, events)
        listview.adapter = adapter
    }

    fun getEventArray(): Array<PeopleListObject> {
        return arrayOf(
            PeopleListObject("Tara", "Studying graphics design, 2nd year", "Interests: Video editing, computers, reading, walking, coffee, dancing","2km"),
            PeopleListObject("Bob", "Studying bachelor of business and IT, 1st year","Computers, programming, gaming","4km"),
            PeopleListObject("Jack", "Studying bachelor of Creative Media, 2nd year","Video editing, reading, coffee, dogs, drinking, dancing, social studying", "~500m"),
            PeopleListObject("John","Studying law, 3rd year", "Computers, reading, business, soccer", "5km"),
            PeopleListObject("Jamie", "Studying Bachelor of Creative Media, 2nd year", "Cats, coffee, Instagram selfies, dancing, yoga, meditation","1km"),
            PeopleListObject("Ishmael","Studying Bachelor Computer Science, 1st Year", "Programming, gaming, computers, vintage tech, social studying","3km")
        )
    }
}

data class PeopleListObject(val name: String, val description: String, val commonInterests: String, val distance: String)
