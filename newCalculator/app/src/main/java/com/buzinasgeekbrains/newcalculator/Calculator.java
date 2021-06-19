package com.buzinasgeekbrains.newcalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    private double memNumber;
    private double curNumber;
    private CalcOperation operation;
    private String memField;
    private String calcField;

    public Calculator(double memNumber, double cirNumber, CalcOperation operation, String memField, String calcField) {
        this.memNumber = memNumber;
        this.curNumber = cirNumber;
        this.operation = CalcOperation.EMPTY;
        this.memField = memField;
        this.calcField = calcField;
    }

    public String getMemField() {
        return this.memField;
    }

    public String getCalcField() {
        return this.calcField;
    }

    public CalcOperation getOperation() {
        return this.operation;
    }

    public void setCurNumber(String number) {
        if (number.equals("")) {
            this.curNumber = 0.0;
        } else {
            this.curNumber = Double.parseDouble(number);
        }
        this.calcField = number;
    }

    public void setInMem(String number, CalcOperation operation) {
        this.memNumber = Double.parseDouble(number);
        this.curNumber = 0.0;
        this.operation = operation;

        this.memField = memNumber + operation.toString();
        this.calcField = "";
    }

    public void calc(Double number) {
        switch (this.operation){
            case PLUS:
                this.memNumber = this.memNumber + number;
                break;
            case MINUS:
                this.memNumber = this.memNumber - number;
                break;
            case DIVISION:
                this.memNumber = this.memNumber / number;
                break;
            case MULTIPLY:
                this.memNumber = this.memNumber * number;
                break;
        }
        this.operation = CalcOperation.EMPTY;
        this.curNumber=this.memNumber;

        this.calcField=String.valueOf(curNumber);
        this.memField = this.memField + number + "=" + memNumber;
    }

    protected Calculator(Parcel in) {
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
