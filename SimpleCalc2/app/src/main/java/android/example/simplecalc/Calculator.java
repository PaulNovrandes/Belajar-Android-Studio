package android.example.simplecalc;

import android.text.TextUtils;
import android.util.Log;

public class Calculator {


    public enum Operator {ADD, SUB, DIV, MUL}

    public double add(double firstOperand, double secondOperand){
        return firstOperand + secondOperand;
    }

    public double sub(double firstOperand, double secondOperand){
        return firstOperand - secondOperand;
    }

    public double div(double firstOperand, double secondOperand){
        return firstOperand / secondOperand;
    }

    public double mul(double firstOperand, double secondOperand){
        return firstOperand * secondOperand;
    }
}
