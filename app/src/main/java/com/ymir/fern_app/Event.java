package com.ymir.fern_app;

import java.util.ArrayList;

public class Event extends SuperFern {
    private String date;
    private int duration; // in minutes?
    private ArrayList<String> attendees = new ArrayList<>();
    //enum Type {ACADEMIC, LEISURE}

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getAttendees() {
        return this.attendees;
    }

    public void setAttendees(ArrayList<String> attendees) {
        this.attendees = attendees;
    }
}
