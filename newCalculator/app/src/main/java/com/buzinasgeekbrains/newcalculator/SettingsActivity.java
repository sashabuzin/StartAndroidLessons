package com.buzinasgeekbrains.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {

    private RadioButton rbLightTheme;
    private RadioButton rbDarkTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.AppThemeDark);
        setContentView(R.layout.activity_settings);

        initRBThemes();
    }

    private void initRBThemes() {
        rbLightTheme = findViewById(R.id.rb_lightTheme);
        rbDarkTheme = findViewById(R.id.rb_darkTheme);

        int curCodeStyle = getIntent().getExtras().getInt(Theme.getSettingsThemeStyle());
        if(curCodeStyle == Theme.getMyThemeCodeStyle())  {
            rbLightTheme.setChecked(true);
        } else {
            rbDarkTheme.setChecked(true);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intentResult = new Intent();

        if (rbLightTheme.isChecked()) {
            intentResult.putExtra(Theme.getSettingsThemeStyle(), Theme.getMyThemeCodeStyle());
        } else {
            intentResult.putExtra(Theme.getSettingsThemeStyle(), Theme.getDarkThemeCodeStyle());
        }
        setResult(RESULT_OK, intentResult);

        super.onBackPressed();
    }
}
