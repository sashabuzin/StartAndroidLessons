package com.buzinasgeekbrains.fragments;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class NotesSourceImpl implements NotesSource {
    public List<Notes> getDataSource() {
        return dataSource;
    }

    private List<Notes> dataSource;
//    private Resources resources;

    public NotesSourceImpl () {
        dataSource = new ArrayList<>(20);
    }

    public NotesSourceImpl init() {
        for (int i = 0; i < Notes.listNotes.size(); i++) {
            dataSource.add(Notes.listNotes.get(i));

        }
        return this;
    }

    @Override
    public Notes getCardData(int position) {
        return dataSource.get(position);
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public void deleteCardData(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateCardData(int position, Notes note) {
        dataSource.set(position, note);
    }

    @Override
    public void addCardData(Notes note) {
        dataSource.add(note);
    }

    @Override
    public void clearCardData() {
        dataSource.clear();
    }
}
