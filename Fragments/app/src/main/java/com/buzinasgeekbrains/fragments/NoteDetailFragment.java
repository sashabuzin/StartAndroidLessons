package com.buzinasgeekbrains.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
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
        setActionBar();
//        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_note_detail, container, false);
    }

    private void setActionBar() {
        setHasOptionsMenu(true);
        androidx.appcompat.app.ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setSubtitle("Note details");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.note_detail);
        initDescription(position, textView);
        initPopupMenu(view);
    }

    private void initDescription(int position, TextView textView) {

        textView.setText(Notes.listNotes.get(position).getName());
        textView.append("\n");
        textView.append(Notes.listNotes.get(position).getDescription());
        textView.append("\n");
        textView.append(Notes.listNotes.get(position).getDate().toString());
    }


    private void initPopupMenu(View view) {
        TextView textView = view.findViewById(R.id.note_detail);
        textView.setOnLongClickListener(v -> {
            Activity activity = requireActivity();
            PopupMenu popupMenu = new PopupMenu(activity, v);
            activity.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.action_popup_clear) {
                        initDescription(0,textView);
                        return true;
                    } else if (item.getItemId() == R.id.action_popup_exit) {
                        activity.finish();
                        return true;
                    }
                    return true;
                }
            });
            popupMenu.show();
            return true;
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.action_about);
        if (item != null) {
            item.setVisible(false);
        }
        MenuItem itemAdd = menu.findItem(R.id.action_add);
        if (itemAdd != null) {
            itemAdd.setVisible(false);
        }
        }
}