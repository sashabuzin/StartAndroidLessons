package com.buzinasgeekbrains.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesListFragment extends Fragment {

    public NotesListFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_notes_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            initView(view);

    }

    private void initView(View view) {

        LinearLayout linearLayout = (LinearLayout) view;
        LayoutInflater ltInflater = getLayoutInflater();
        for(int i = 0; i < Notes.listNotes.size(); i++) {

            Notes notes = Notes.listNotes.get(i);
            View item = ltInflater.inflate(R.layout.item, linearLayout, false);
            TextView tv = item.findViewById(R.id.textView);
            tv.setText(notes.getName());
            linearLayout.addView(item);

            final int position = i;
            tv.setOnClickListener(v -> showDescription(position));
//            TextView textView = new TextView(getContext());
//            textView.setText(notes.getName());
//            textView.setTextSize(30);
//            final int position = i;
//            textView.setOnClickListener(v -> {
//                showDescription(position);
//            });
//            linearLayout.addView(textView);
        }
    }

    void showDescription(int position) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            showDescriptionPort(position);
        } else {
            showDescriptionLand(position);
        }

    }

    void showDescriptionLand(int position) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_2, NoteDetailFragment.newInstance(position))
                .commit();
    }
    void showDescriptionPort(int position) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_1, NoteDetailFragment.newInstance(position))
                .addToBackStack(null)
                .commit();
    }
}