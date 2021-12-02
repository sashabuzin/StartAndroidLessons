package com.buzinasgeekbrains.fragments;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notes implements Parcelable {

    public static List<Notes> listNotes = new ArrayList<>();
    private String name;
    private String description;
    private Date date;

    public static Notes note = new Notes("Note1", "Note1 description");
    public static Notes note2 = new Notes("Note2", "Note2 description");
    public static Notes note3 = new Notes("Note3", "Note3 description");
    public static Notes note4 = new Notes("Note4", "Note3 description");

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
