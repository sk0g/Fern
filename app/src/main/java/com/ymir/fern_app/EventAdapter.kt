package com.ymir.fern_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class EventAdapter(val context: Context,
                   val dataSource: Array<EventListObject>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.event_listrow, p2, false)

        val event = getItem(p0) as EventListObject

        val desc = rowView.findViewById(R.id.event_row_description) as TextView
        val comm = rowView.findViewById(R.id.event_row_common) as TextView
        val dist = rowView.findViewById(R.id.event_row_distance) as TextView

        desc.text = event.description
        comm.text = ("Shared interests: " + event.commonInterests)
        dist.text = event.distance

        return rowView
    }
}