package com.buzinasgeekbrains.newcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static com.buzinasgeekbrains.newcalculator.Theme.*;

public class MainActivity extends AppCompatActivity {
    private TextView calcField;
    private TextView memField;
    private Calculator calc;
    private final static String keyCalc = "calc";
    private static final String NameSharedPreference = "CALC";
    private static final String AppTheme = "APP_THEME";
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;

    @Override
    protected void onSaveInstanceState(@NonNull @NotNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyCalc, calc);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calc = (Calculator) savedInstanceState.getParcelable(keyCalc);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        setTheme(getAppTheme(R.style.MyTheme));

        calcField = findViewById(R.id.calcField);
        memField = findViewById(R.id.memField);
        calc = new Calculator(0.0, 0.0, CalcOperation.EMPTY, "", "");

        setBtnNumClickListener();
        setBtnDelClickListener();
        setBtnPlusClickListener();
        setBtnMinusClickListener();
        setBtnDivisionClickListener();
        setBtnMultiplyClickListener();
        setBtnEqualClickListener();
        setBtnCClickListener();
        setBtnDotClickListener();
        setBtnSettingsClickListener();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            int retCodeStyle = data.getIntExtra(getSettingsThemeStyle(), -1);
            if (retCodeStyle == getDarkThemeCodeStyle()) {
                setAppTheme(getDarkThemeCodeStyle());
            } else {
                setAppTheme(Theme.getMyThemeCodeStyle());
            }
            recreate();
        }
    }

    private void setBtnSettingsClickListener() {
        findViewById(R.id.btn_settings).setOnClickListener(v -> {
            Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);

            runSettings.putExtra(getSettingsThemeStyle(),getCodeStyle(Theme.getMyThemeCodeStyle()));
            startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);
        });
    }

    private void setBtnCClickListener() {
        findViewById(R.id.btn_c).setOnClickListener(v -> {
            calc.setCurNumber("0");
            setFields();
        });
    }

    private void setBtnDotClickListener() {
        findViewById(R.id.btn_dot).setOnClickListener(v -> {
            if (calcField.getText().toString().contains(".")) return;
            if (calcField.getText().length()==0) return;

            calc.setCurNumber(calcField.getText()+".");
            setFields();
        });
    }

    private void setBtnEqualClickListener() {
        findViewById(R.id.btn_equal).setOnClickListener(v -> {
            if (calcField.getText().length()==0) return;
            if (calc.getOperation().equals(CalcOperation.EMPTY)) return;

            calc.calc(Double.valueOf(calcField.getText().toString()));
            setFields();
        });
    }

    private void setInMem(CalcOperation calcoper){
        calc.setInMem(calcField.getText().toString(),calcoper);
        setFields();
    }

    private void setFields(){
        memField.setText(calc.getMemField());
        calcField.setText(calc.getCalcField());
    }

    private void setBtnPlusClickListener() {
        findViewById(R.id.btn_plus).setOnClickListener(v -> {
            if (calcField.getText().length()==0) return;

            setInMem(CalcOperation.PLUS);
        });
    }

    private void setBtnMinusClickListener() {
        findViewById(R.id.btn_minus).setOnClickListener(v -> {
            if (calcField.getText().length()==0) return;

            setInMem(CalcOperation.MINUS);
        });
    }

    private void setBtnDivisionClickListener() {
        findViewById(R.id.btn_division).setOnClickListener(v -> {
            if (calcField.getText().length()==0) return;

            setInMem(CalcOperation.DIVISION);
        });
    }

    private void setBtnMultiplyClickListener() {
        findViewById(R.id.btn_multiply).setOnClickListener(v -> {
            if (calcField.getText().length()==0) return;

            setInMem(CalcOperation.MULTIPLY);
        });
    }

    private void setBtnDelClickListener() {
        findViewById(R.id.btn_del).setOnClickListener(v -> {
            if (calcField.getText().length()==0) return;

            calc.setCurNumber(calcField.getText().subSequence(0,calcField.getText().length()-1).toString());
            setFields();
        });
    }

    private void setBtnNumClickListener() {
        HashMap<Integer,String> valuesNumButton = getValuesNumButton();

        View.OnClickListener btnNumClickListener = v -> {
            calc.setCurNumber(calcField.getText()+valuesNumButton.get(v.getId()));
            setFields();
        };

        findViewById(R.id.btn_0).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_1).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_2).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_3).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_4).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_5).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_6).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_7).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_8).setOnClickListener(btnNumClickListener);
        findViewById(R.id.btn_9).setOnClickListener(btnNumClickListener);
    }

    private HashMap<Integer, String> getValuesNumButton() {
        HashMap<Integer, String> valuesNumButton = new HashMap<>();

        valuesNumButton.put(R.id.btn_0,"0");
        valuesNumButton.put(R.id.btn_1,"1");
        valuesNumButton.put(R.id.btn_2,"2");
        valuesNumButton.put(R.id.btn_3,"3");
        valuesNumButton.put(R.id.btn_4,"4");
        valuesNumButton.put(R.id.btn_5,"5");
        valuesNumButton.put(R.id.btn_6,"6");
        valuesNumButton.put(R.id.btn_7,"7");
        valuesNumButton.put(R.id.btn_8,"8");
        valuesNumButton.put(R.id.btn_9,"9");

        return valuesNumButton;
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle){
        switch(codeStyle){
            case 0:
                return R.style.MyTheme;
            case 1:
                return R.style.AppThemeDark;
            default:
                return R.style.MyTheme;
        }
    }

    private int getCodeStyle(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }
}