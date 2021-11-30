package com.buzinasgeekbrains.fragments;

import java.util.Date;
import java.util.List;

public class Notes {

    public static List<Notes> listNotes;
    private String name;
    private String description;
    private Date date;

    public Notes(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = new Date();
        listNotes.add(this);
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
