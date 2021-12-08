package com.buzinasgeekbrains.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemFragment extends Fragment {

    private static final String ARG_POSITION = "position_arg";
    private static final String ARG_ITEM = "item_arg";

    private int position;
    private static NotesSourceImpl note;

    public EditItemFragment() {
    }

    public static EditItemFragment newInstance(int position, NotesSourceImpl notes) {
        EditItemFragment fragment = new EditItemFragment();
        Bundle args = new Bundle();
        note = notes;
        args.putInt(ARG_POSITION, position);
        args.putParcelable(ARG_ITEM, note);
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
        return inflater.inflate(R.layout.fragment_edit_item, container, false);
    }

    private void setActionBar() {
        setHasOptionsMenu(true);
        androidx.appcompat.app.ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setSubtitle("Edit Note");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.note_detail_edit_frag);
        initDescription(position, textView);
        EditText editName = view.findViewById(R.id.note_edit_name);
        EditText editDescription = view.findViewById(R.id.note_edit_description);
        Button confirm = view.findViewById(R.id.button_confirm_edit_item);

        confirm.setOnClickListener(v -> {
            Notes.listNotes.get(position).setName(editName.getText().toString());
            Notes.listNotes.get(position).setDescription(editDescription.getText().toString());
            getParentFragmentManager().popBackStack();
        });

    }

    private void initDescription(int position, TextView textView) {

//        textView.setText(Notes.listNotes.get(position).getName());
//        textView.append("\n");
//        textView.append(Notes.listNotes.get(position).getDescription());
//        textView.append("\n");
//        textView.append(Notes.listNotes.get(position).getDate().toString());
        textView.setText(Notes.listNotes.get(position).getName());
        textView.append("\n");
        textView.append(Notes.listNotes.get(position).getDescription());
        textView.append("\n");
        textView.append(Notes.listNotes.get(position).getDate().toString());
    }
}