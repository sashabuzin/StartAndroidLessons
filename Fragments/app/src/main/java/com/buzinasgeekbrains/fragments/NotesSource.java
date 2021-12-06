package com.buzinasgeekbrains.fragments;

public interface NotesSource {
    Notes getCardData(int position);
    int size();
    void deleteCardData(int position);
    void updateCardData(int position, Notes note);
    void addCardData(Notes note);
    void clearCardData();
}
