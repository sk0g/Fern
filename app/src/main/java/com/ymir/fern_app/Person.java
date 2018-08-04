package com.ymir.fern_app;

//import android.support.v7.app.ActionBarActivity;

public class Person {
    @com.google.gson.annotations.SerializedName("id")
    private int personId;
    @com.google.gson.annotations.SerializedName("firstName")
    private String firstName;
    @com.google.gson.annotations.SerializedName("secondName")
    private String secondName;
    @com.google.gson.annotations.SerializedName("university")
    private String university;
    @com.google.gson.annotations.SerializedName("campus")
    private String campus;
    @com.google.gson.annotations.SerializedName("degree")
    private String degree;
    @com.google.gson.annotations.SerializedName("bio")
    private String bio;
    private double longitude;
    private double latitude;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private static final Person holder = new Person();

    public static Person getInstance() {
        return holder;
    }
}