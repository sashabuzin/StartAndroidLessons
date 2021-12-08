package com.buzinasgeekbrains.fragments;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notes implements Parcelable {

    public static List<Notes> listNotes = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String description;
    private Date date;

    public static Notes note = new Notes("Note1", "Note1 description");
    public static Notes note2 = new Notes("Note2", "Note2 description");
    public static Notes note3 = new Notes("Note3", "Note3 description");
    public static Notes note4 = new Notes("Note4", "Note4 description");
    public static Notes note5 = new Notes("Note5", "Note5 description");
    public static Notes note6 = new Notes("Note6", "Note6 description");
    public static Notes note7 = new Notes("Note7", "Note7 description");
    public static Notes note8 = new Notes("Note8", "Note8 description");
    public static Notes note9 = new Notes("Note9", "Note9 description");
    public static Notes note10 = new Notes("Note10", "Note10 description");
    public static Notes note11 = new Notes("Note11", "Note11 description");
    public static Notes note12 = new Notes("Note12", "Note12 description");
    public static Notes note13 = new Notes("Note13", "Note13 description");
    public static Notes note14 = new Notes("Note14", "Note14 description");
    public static Notes note15 = new Notes("Note15", "Note15 description");
    public static Notes note16 = new Notes("Note16", "Note16 description");
    public static Notes note17 = new Notes("Note17", "Note17 description");
    public static Notes note18 = new Notes("Note18", "Note18 description");
    public static Notes note19 = new Notes("Note19", "Note19 description");
    public static Notes note20 = new Notes("Note20", "Note20 description");

    public Notes(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = new Date();
        listNotes.add(this);
    }

    protected Notes(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
    }
}
