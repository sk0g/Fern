package com.ymir.fern_app;

import java.util.ArrayList;

public class Person extends SuperFern {
    private float distance;
    private ArrayList<String> attending = new ArrayList<>();

    public float getDistance()
    {
        return this.distance;
    }

    public void setDistance(float distance)
    {
        this.distance = distance;
    }

    public ArrayList<String> getAttending() {
        return this.attending;
    }

    public void setAttending(ArrayList<String> attending) {
        this.attending = attending;
    }
}
