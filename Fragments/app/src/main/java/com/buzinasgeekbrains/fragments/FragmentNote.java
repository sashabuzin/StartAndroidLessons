package com.buzinasgeekbrains.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FragmentNote extends Fragment {

    Note note1;
    Note note2;
    Note note3;
    Note note4;
    Note note5;

    private List<String> nameList;
    List<TextView> layouts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createNotes();
        initList(view);

    }

    public void onShowDetails(int index) {

//        Intent intent = new Intent();
//        intent.setClass(getActivity(), NoteActivity.class);
//        intent.putExtra(FragmentDetails.ARG_INDEX, index);
//        startActivity(intent);
    }

    public void createNotes() {
        note1 = new Note("Хлеб", "Купить хлеб", "Во время похода за продуктам обязательно купить хлеб");
        note2 = new Note("Яйца", "Купить яйца", "Во время похода за продуктам обязательно купить яйца");
        note3 = new Note("Молоко", "Купить молоко", "Во время похода за продуктам обязательно купить молоко");
        note4 = new Note("Мороженое", "Купить мороженое", "Во время похода за продуктам обязательно купить мороженое");
        note5 = new Note("Вода", "Купить воду", "Во время похода за продуктам обязательно купить воду");
        nameList = new ArrayList<>();
        nameList.add(note1.getName());
        nameList.add(note2.getName());
        nameList.add(note3.getName());
        nameList.add(note4.getName());
        nameList.add(note5.getName());
    }

    private void initList(@NotNull View view) {
        layouts = new ArrayList<>();
        LinearLayout layoutView = (LinearLayout) view;
        for(int i=0; i < nameList.size(); i++){
            String prop = nameList.get(i);
            TextView pr = new TextView(getContext());
            pr.setText(prop);
            pr.setTextSize(30);
            layoutView.addView(pr);
            final int id = i;
            layouts.add(pr);
            pr.setOnClickListener(v -> {
//                onShowDetails(id);

            });

        }
    }
}
