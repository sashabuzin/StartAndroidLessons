package com.buzinasgeekbrains.fragments;

import java.util.Date;

public class Notes {
    private String name;
    private String description;
    private Date date;

    public Notes(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = new Date();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
}
