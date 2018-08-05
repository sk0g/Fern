package com.ymir.fern_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ListView
import com.ymir.fern_app.ActivitySwitcher.switchToMap
import com.ymir.fern_app.ActivitySwitcher.switchToProfile

class EventViewActivity : AppCompatActivity() {

    lateinit var mMapButton: Button
    lateinit var mProfileButton: Button
    lateinit var listview: ListView

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

        listview = findViewById(R.id.event_list_view)

        val events = getEventArray()

        val adapter = EventAdapter(this, events)
        listview.adapter = adapter
    }

    fun getEventArray(): Array<EventListObject> {
        return arrayOf(
                EventListObject("Drinking, dancing", "Rad party at uni hospital", "500m"),
                EventListObject("Reading, social studying", "Bored at library :(", "500m"),
                EventListObject("Netflix, social studying", "Omg exam tomorrow pls help", "800m"),
                EventListObject("Drinking, dancing", "Exam tomorrow. Haven't studied. Anyone need a drinking partner?", "500m"),
                EventListObject("Gaming, computers, programming", "LAN Party, ICT Students only", "1km"),
                EventListObject("Yoga, meditation, reading", "Yoga & Tai-Chi outside uni library", "700m"),
                EventListObject("computers, programming, social studying", "Arrays start at 1 right1//1?!?!?!?", "2km"),
                EventListObject("Computers, programming, gaming", "Comp Sci catch up before 1806ICT culls over half our student base", "2km"),
                EventListObject("Soccer, walking, netflix", "Casual soccer game", "4km")
        )
    }
}

data class EventListObject(val commonInterests: String, val description: String, val distance: String)
