package com.buzinasgeekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    Button buttonClear, buttonDivision, buttonMultiplication, buttonPercent, button1, button2,
            button3, button4, button5, button6, button7, button8, button9, button0, buttonDelete,
            buttonPlus, buttonMinus, buttonPoint, buttonResult;

    TextView editText, resultText;

    String process = "";

    int pointCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findButtons();


    }

    private void findButtons() {
        editText = findViewById(R.id.edit_text);
        resultText = findViewById(R.id.result_text);

        buttonClear = findViewById(R.id.button_clear);
        buttonDivision = findViewById(R.id.button_division);
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonPercent = findViewById(R.id.button_percent);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button0 = findViewById(R.id.button_0);
        buttonDelete = findViewById(R.id.button_delete);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonPoint = findViewById(R.id.button_point);
        buttonResult = findViewById(R.id.button_result);

        button0.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "0");
        });

        button1.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "1");
        });

        button2.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "2");
        });

        button3.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "3");
        });

        button4.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "4");
        });

        button5.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "5");
        });

        button6.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "6");
        });

        button7.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "7");
        });

        button8.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "8");
        });

        button9.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "9");
        });

        buttonClear.setOnClickListener(v -> {
            editText.setText("");
            resultText.setText("");
            pointCount = 0;
        });

        buttonDivision.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "/");
        });

        buttonMultiplication.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "*");
        });

        buttonPercent.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "%");
        });

        buttonDelete.setOnClickListener(v -> {
            process = editText.getText().toString();
            if (process.length() == 1) pointCount = 0;
            if (process.length() > 0) {
                editText.setText(process.substring(0, process.length() - 1));
                if (!editText.getText().toString().equals(".")) pointCount = 0;

            }
        });

        buttonPlus.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "+");
        });

        buttonMinus.setOnClickListener(v -> {
            process = editText.getText().toString();
            editText.setText(process + "-");
        });

        buttonPoint.setOnClickListener(v -> {
                process = editText.getText().toString();
                if(process.length() == 0) {
                    editText.setText(process + "0.");
                    pointCount++;
                }
                if (pointCount == 0) {
                    editText.setText(process + ".");
                    pointCount++;
                }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = editText.getText().toString();

                process = process.replaceAll("%","/100");
                pointCount = 0;
            }
        });
    }

}