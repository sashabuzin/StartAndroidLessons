package com.buzinasgeekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChangeThemeActivity extends AppCompatActivity {

    public static final String PREFERENCES_NAME ="main";
    public static final String THEME_NAME ="theme";

    public static final int AppThemeDefault = 0;
    public static final int AppThemeMy = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(loadAppTheme());
        setContentView(R.layout.activity_change_theme);
        initElements();



    }

    private void initElements() {
        RadioButton radioStandart = findViewById(R.id.radioStandart);
        RadioButton radioMyTheme = findViewById(R.id.radioMy);
        Button applyTheme = findViewById(R.id.button_apply);

        if (getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).getInt(THEME_NAME, AppThemeDefault) == 0) {
            radioStandart.setChecked(true);
        } else radioMyTheme.setChecked(true);


        radioStandart.setOnClickListener(v -> {
            saveAppTheme(AppThemeDefault);
            recreate();
        });

        radioMyTheme.setOnClickListener(v -> {
            saveAppTheme(AppThemeMy);
            recreate();
        });

        applyTheme.setOnClickListener(v -> {
            finish();
        });
    }

    public static int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeMy:
                return R.style.MyTheme;
            case AppThemeDefault:
                return R.style.Theme_Calculator;
            default: return R.style.Theme_Calculator;
        }
    }

    private int loadAppTheme() {
        int codeTheme = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).getInt(THEME_NAME, AppThemeDefault);
        return codeStyleToStyleId(codeTheme);
    }

    private void saveAppTheme(int code) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        sharedPreferences.edit().putInt(THEME_NAME, code).apply();
    }


}