package com.ymir.fern_app;

import java.util.ArrayList;

public abstract class SuperFern {
    private String name;
    private int id;
    private ArrayList<Integer> interests = new ArrayList<>();
    private String description;

    protected String getName()
    {
        return this.name;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    protected int getID()
    {
        return this.id;
    }

    protected void setID(int id)
    {
        this.id = id;
    }

    protected ArrayList<Integer> getInterests()
    {
        return this.interests;
    }

    protected void setInterests(ArrayList<Integer> interests)
    {
        this.interests = interests;
    }

    protected String getDescription()
    {
        return this.description;
    }

    protected void setDescription(String description)
    {
        this.description = description;
    }
}