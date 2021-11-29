package com.buzinasgeekbrains.calculator;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class Calculator implements Parcelable {

    private String resultText = "";
    private String editTextBeforeMathSymbol = "";
    private Double editTextAfterMathSymbol = 0.00D;
    private String tempText ="";
    private boolean isUsedMathSymbol = false;
    private double tempComputation = 0.00D;
    private MatchSymbols matchSymbol = MatchSymbols.PLUS;


    public Calculator (){

    };

    public void addition (TextView view) {
        if (!isUsedMathSymbol) {
            isUsedMathSymbol = true;
            editSymbol(MatchSymbols.PLUS);
            tempComputation = Double.parseDouble(tempText);
            editTextBeforeMathSymbol = tempText + "+";
            view.setText(editTextBeforeMathSymbol);
            clearTempText();
        }


    }

    public void subtraction (TextView view) {
        if (!isUsedMathSymbol) {
            isUsedMathSymbol = true;
            editSymbol(MatchSymbols.MINUS);
            tempComputation = Double.parseDouble(tempText);
            editTextBeforeMathSymbol = tempText + " - ";
            view.setText(editTextBeforeMathSymbol);
            clearTempText();
        }
//        return Math.round(((a - b)* 100)/100D);
    }

    public void multiple (TextView view) {
        if (!isUsedMathSymbol) {
            isUsedMathSymbol = true;
            editSymbol(MatchSymbols.MULTIPLE);
            tempComputation = Double.parseDouble(tempText);
            editTextBeforeMathSymbol = tempText + "*";
            view.setText(editTextBeforeMathSymbol);
            clearTempText();
        }
    }

    public void division (TextView view) {
        if (!isUsedMathSymbol) {
            isUsedMathSymbol = true;
            editSymbol(MatchSymbols.DIVISION);
            tempComputation = Double.parseDouble(tempText);
            editTextBeforeMathSymbol = tempText + "/";
            view.setText(editTextBeforeMathSymbol);
            clearTempText();
        }
    }

    public void percent (TextView view) {
        tempText = String.valueOf(Math.round(((Integer.valueOf(tempText)/100)*100)/100D));
    }

    public void delete (TextView v) {
//        if ()
        tempText = tempText.substring(0, tempText.length() - 1);
        v.setText(tempText);
    }

    public void clear (TextView e, TextView r) {
        defaultState(e, r);

    }

    private void defaultState(TextView e, TextView r) {
        this.resultText = "";
        this.editTextBeforeMathSymbol = "";
        this.editTextAfterMathSymbol = 0D;
        clearTempText();
        this.isUsedMathSymbol = false;
        this.tempComputation = 0D;
        this.matchSymbol = MatchSymbols.DEFAULT;
        e.setText("0");
        r.setText("0");

    }

    public void addSymbol (double a, TextView view) {
        this.tempText = tempText + (int) a;
        view.setText(editTextBeforeMathSymbol + tempText);
    }

    public void addPoint (TextView view) {
        if (tempText.length() == 0) {
            this.tempText = "0.";

        } else if (tempText.indexOf(".") < 0) {
            this.tempText = tempText + ".";
        }
        view.setText(editTextBeforeMathSymbol + tempText);


    }

    private void editSymbol (MatchSymbols s) {
        this.matchSymbol = s;
    }
    public void beforeResult (TextView v) {
        result(v, this.matchSymbol);
    }

    public void result (TextView v, MatchSymbols matchSymbol) {
        editTextAfterMathSymbol = Double.parseDouble(tempText);
        switch (matchSymbol) {
            case (PLUS) :
                resultText = String.valueOf(tempComputation + editTextAfterMathSymbol);
                v.setText(resultText);
                clearAfterResult();
            case ("MINUS"):
                resultText = String.valueOf(tempComputation - editTextAfterMathSymbol);
                v.setText(resultText);
                clearAfterResult();
            case ("MULTIPLE"):
                resultText = String.valueOf(tempComputation * editTextAfterMathSymbol);
                v.setText(resultText);
                clearAfterResult();
            case ("DIVISION"):
                resultText = String.valueOf(tempComputation / editTextAfterMathSymbol);
                v.setText(resultText);
                clearAfterResult();
            case ("DEFAULT"):
                v.setText("default");
            default:
                return;
        }

    }

    private void clearAfterResult() {
        this.editTextBeforeMathSymbol = "";
        this.editTextAfterMathSymbol = 0D;
        clearTempText();
        this.isUsedMathSymbol = false;
        this.tempComputation = 0D;
        this.matchSymbol = MatchSymbols.DEFAULT;
    }

    private void clearTempText() {
        this.tempText = "";
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
        editTextAfterMathSymbol = in.readDouble();
        tempText = in.readString();
        isUsedMathSymbol = in.readBoolean();
        tempComputation = in.readDouble();
        matchSymbol = in.readTypedObject(CREATOR);

    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
