package com.buzinasgeekbrains.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteDetailFragment extends Fragment {

    private static final String ARG_POSITION = "position_arg";

    private int position;

    public NoteDetailFragment() {
    }

    public NoteDetailFragment(int position) {
    }


    // TODO: Rename and change types and number of parameters
    public static NoteDetailFragment newInstance(int position) {
        NoteDetailFragment fragment = new NoteDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, position);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.note_detail);
        textView.setText(Notes.listNotes.get(position).getName());
        textView.append("\n");
        textView.append(Notes.listNotes.get(position).getDescription());
        textView.append("\n");
        textView.append(Notes.listNotes.get(position).getDate().toString());
    }
}