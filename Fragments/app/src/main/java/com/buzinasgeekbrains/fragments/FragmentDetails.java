package com.buzinasgeekbrains.fragments;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

import org.jetbrains.annotations.NotNull;

public class FragmentDetails extends Fragment {

    public static final String ARG_INDEX = "index";
    private int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details, container, false);
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        MaterialTextView notesFrag = view.findViewById(R.id.textName);
        TypedArray images = getResources().obtainTypedArray(R.array.properties);
        notesFrag.setText(images.getResourceId(index, -1));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
        Intent intent = new Intent();
        intent.getExtras();

    }



    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] properties = getResources().getStringArray(R.array.properties);
        for(int i=0; i < properties.length; i++){
            String prop = properties[i];
            TextView pr = new TextView(getContext());
            pr.setText(prop);
            pr.setTextSize(30);
            layoutView.addView(pr);
        }
    }
}