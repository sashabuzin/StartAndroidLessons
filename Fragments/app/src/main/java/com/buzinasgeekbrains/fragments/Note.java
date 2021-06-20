package com.buzinasgeekbrains.fragments;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private String name;
    private String Description;
    private Date date;
    private String text;

    public Note(String name, String description, Date date, String text) {
        this.name = name;
        Description = description;
        this.date = date;
        this.text = text;
    }

    protected Note(Parcel in) {
        name = in.readString();
        Description = in.readString();
        text = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(Description);
        dest.writeString(text);
    }

}
