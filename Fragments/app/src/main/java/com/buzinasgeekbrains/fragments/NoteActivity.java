package com.buzinasgeekbrains.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            // Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
//            finish();
//            return;
//        }
//
//        if (savedInstanceState == null) {
//            FragmentDetails details = new FragmentDetails();
//            details.setArguments(getIntent().getExtras());
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, details).commit();
//        }
    }
}
