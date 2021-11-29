package com.buzinasgeekbrains.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Calculator calculator;


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(loadAppTheme());
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        initView();

    }

    private int loadAppTheme() {
        int codeTheme = getSharedPreferences(ChangeThemeActivity.PREFERENCES_NAME, MODE_PRIVATE).getInt(ChangeThemeActivity.THEME_NAME, ChangeThemeActivity.AppThemeDefault);
        return ChangeThemeActivity.codeStyleToStyleId(codeTheme);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable("KeyCalc", calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable("KeyCalc");
    }

    public void initView() {
        Button btnEditTheme = findViewById(R.id.button_editTheme);
        TextView resultText = findViewById(R.id.textViewResult);
        TextView editText = findViewById(R.id.textViewEdit);
        Button btnPoint = findViewById(R.id.button_point);
        Button btnZero = findViewById(R.id.button_0);
        Button btnResult = findViewById(R.id.button_result);
        Button btn1 = findViewById(R.id.button_1);
        Button btn2 = findViewById(R.id.button_2);
        Button btn3 = findViewById(R.id.button_3);
        Button btnPlus = findViewById(R.id.button_plus);
        Button btn4 = findViewById(R.id.button_4);
        Button btn5 = findViewById(R.id.button_5);
        Button btn6 = findViewById(R.id.button_6);
        Button btnMinus = findViewById(R.id.button_minus);
        Button btn7 = findViewById(R.id.button_7);
        Button btn8 = findViewById(R.id.button_8);
        Button btn9 = findViewById(R.id.button_9);
        Button btnPercent = findViewById(R.id.button_percent);
        Button btnClear = findViewById(R.id.button_clear);
        Button btnDivision = findViewById(R.id.button_division);
        Button btnMultiple = findViewById(R.id.button_multiple);
        Button btnDelete = findViewById(R.id.button_delete);

        btnEditTheme.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangeThemeActivity.class);
//            getTheme().toString();
//            intent.putExtra(getTheme(), );
            startActivity(intent);
        });

        btnPoint.setOnClickListener(v -> {
            calculator.addPoint(editText);
        });
        btnZero.setOnClickListener(v -> {
            calculator.addSymbol(0D, editText);
        });
        btn1.setOnClickListener(v -> {
            calculator.addSymbol(1D, editText);
        });
        btn2.setOnClickListener(v -> {
            calculator.addSymbol(2D, editText);
        });
        btn3.setOnClickListener(v -> {
            calculator.addSymbol(3D, editText);
        });
        btn4.setOnClickListener(v -> {
            calculator.addSymbol(4D, editText);
        });
        btn5.setOnClickListener(v -> {
            calculator.addSymbol(5D, editText);
        });
        btn6.setOnClickListener(v -> {
            calculator.addSymbol(6D, editText);
        });
        btn7.setOnClickListener(v -> {
            calculator.addSymbol(7D, editText);
        });
        btn8.setOnClickListener(v -> {
            calculator.addSymbol(8D, editText);
        });
        btn9.setOnClickListener(v -> {
            calculator.addSymbol(9D, editText);
        });
        btnPercent.setOnClickListener(v -> {
            calculator.percent(editText);
        });
        btnPlus.setOnClickListener(v -> {
            calculator.addition(editText);
        });
        btnMinus.setOnClickListener(v -> {
            calculator.subtraction(editText);
        });
        btnDivision.setOnClickListener(v -> {
            calculator.division(editText);
        });
        btnMultiple.setOnClickListener(v -> {
            calculator.multiple(editText);
        });
        btnDelete.setOnClickListener(v -> {
            calculator.delete(editText);
        });
        btnResult.setOnClickListener(v -> {
            calculator.beforeResult(resultText);
        });
        btnClear.setOnClickListener(v -> {
            calculator.clear(editText, resultText);
        });
    }




}