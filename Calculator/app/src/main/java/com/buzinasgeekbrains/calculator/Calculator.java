package com.buzinasgeekbrains.calculator;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class Calculator implements Parcelable {

    private String resultText = "0.00";
    private String editTextBeforeMathSymbol = "0.00";
    private String editTextAfterMathSymbol = "0.00";
    public String tempText ="";
    private boolean isUsedMathSymbol = false;
    private double tempComputation = 0.00D;
    private String matchSymbol = MatchSymbols.DEFAULT.toString();

    public Calculator (){

    };

    private double addition (double a, double b) {
        return Math.round(((a + b)* 100)/100D);
    }

    private double subtraction (double a, double b) {

        return Math.round(((a - b)* 100)/100D);
    }

    private double multiple (double a, double b) {
        double roundOffA = Math.round(a*100)/100D;
        double roundOffB = Math.round(b*100)/100D;
        return Math.round(((roundOffA*roundOffB) * 100)/100D);
    }

    private double division (double a, double b) {
        double roundOffA = Math.round(a*100)/100D;
        double roundOffB = Math.round(b*100)/100D;
        return Math.round(((roundOffA/roundOffB) * 100)/100D);
    }

    public void percent () {
        tempText = String.valueOf(Math.round(((Integer.valueOf(tempText)/100)*100)/100D));
    }

    public void delete (TextView v) {
//        if ()
        this.tempText = tempText.substring(0, tempText.length() - 1);
        v.setText(tempText);
    }

    public void clear () {
        defaultState();
    }

    private void defaultState() {
        this.resultText = "0.00";
        this.editTextBeforeMathSymbol = "0.00";
        this.editTextAfterMathSymbol = "0.00";
        this.tempComputation = 0.00D;
        this.tempText = "";
        this.matchSymbol = "";
    }

    public void addSymbol (double a) {
        this.tempText = tempText + String.valueOf((int)a);
    }

    public void addPoint () {
        if (tempText.indexOf(".") < 0) {
            this.tempText = tempText + ".";
        }

    }

    public void editSymbol (MatchSymbols s) {
        this.matchSymbol = s.toString();
    }

    public void result (TextView v) {
        switch (matchSymbol) {
            case ("PLUS") :
                resultText = String.valueOf(Double.valueOf(editTextBeforeMathSymbol) + Double.valueOf(editTextBeforeMathSymbol));
                v.setText(resultText);
            case ("MINUS"):
                resultText = String.valueOf(Double.valueOf(editTextBeforeMathSymbol) - Double.valueOf(editTextBeforeMathSymbol));
                v.setText(resultText);
            case ("MULTIPLE"):
                resultText = String.valueOf(Double.valueOf(editTextBeforeMathSymbol) * Double.valueOf(editTextBeforeMathSymbol));
                v.setText(resultText);
            case ("DIVISION"):
                resultText = String.valueOf(Double.valueOf(editTextBeforeMathSymbol) / Double.valueOf(editTextBeforeMathSymbol));
                v.setText(resultText);
            default:
                throw new IllegalStateException("Unexpected value: " + matchSymbol);
        }

    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Calculator createFromParcel(Parcel source) {
            return new Calculator(source);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[0];
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.Q)
    Calculator(Parcel in) {
        resultText = in.readString();
        editTextBeforeMathSymbol = in.readString();
        editTextAfterMathSymbol = in.readString();
        tempText = in.readString();
        isUsedMathSymbol = in.readBoolean();
        tempComputation = in.readDouble();
        matchSymbol = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
