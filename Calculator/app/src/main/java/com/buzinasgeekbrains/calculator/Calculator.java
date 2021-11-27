package com.buzinasgeekbrains.calculator;

public class Calculator {
    private String resultText = "0.00";
    private String editText = "0.00";
    private double tempComputation = 0.00D;

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

    private double percent (double a) {
        return Math.round(((a/100)*100)/100D);
    }

    public double clear () {
        return 0D;
    }


}
