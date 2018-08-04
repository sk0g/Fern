package com.ymir.fern_app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.view.View

object ActivitySwitcher {
    fun switchToMap(context: Context, view: View) {
        val intent  = Intent(context, MapsActivity::class.java)
        context.startActivity(intent)
    }

    fun switchToProfile(context: Context, view: View) {
        val intent  = Intent(context, ProfileActivity::class.java)
        context.startActivity(intent)
    }

    fun switchToEvents(context: Context, view: View) {
        val intent  = Intent(context, EventViewActivity::class.java)
        context.startActivity(intent)
    }

/*    fun switchToPeople(context: Context, view: View) {
        val intent  = Intent(context, PeopleActivity::class.java)
        context.startActivity(intent)
    }*/
}