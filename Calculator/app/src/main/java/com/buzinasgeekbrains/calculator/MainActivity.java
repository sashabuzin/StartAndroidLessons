package com.buzinasgeekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInterface();
    }

    private void initInterface() {
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
    }
}