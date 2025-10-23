package org.example;

import javax.swing.*;

public class Model {
    private double num1;
    private double num2;
    private double result;
    private String oper = "\0";
    private boolean firstEntered = false;
    private boolean justCalculated = false;

    private String display = "0";
    public String getDisplay() { return display; }

    public void appendDigit(String d) {
        String text = display;
        if (!isNumeric(text)) {
            display = d;
            justCalculated = false;
            return;
        }
        if (justCalculated || "0".equals(text)) {
            display = d;
            justCalculated = false;
        } else {
            display = text + d;
        }
    }

    public void applyOperator(String newOper) {
        String text = display;
        if (!isNumeric(text)) {
            return;
        }
        if (firstEntered && justCalculated) {
            oper = newOper;
            return;
        }
        if (firstEntered ) {
            num2 = (Double.parseDouble(text));
            double res;
            switch (oper) {
                case "+": res = num1 + num2; break;
                case "-": res = num1 - num2; break;
                case "*": res = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        display = "Nie można dzielić przez 0";
                        firstEntered = false;
                        oper = "\0";
                        justCalculated = true;
                        return;
                    }
                    res = num1 / num2;
                    break;
                default: res = num1; break;
            }
            result = res;
            num1 = res;
            setResultText(res);
            justCalculated = true;
        } else {
            num1 = Double.parseDouble(text);
            firstEntered = true;
            justCalculated = true;
        }
        oper = newOper;
    }

    public void clearAll() {
        display = "0";
        num1 = 0;
        num2 = 0;
        result = 0;
        firstEntered = false;
        oper = "\0";
        justCalculated = false;
    }

    public void backspace() {
        String text = display;
        if (!isNumeric(text)) {
            display = "0";
            justCalculated = false;
            return;
        }
        if (text.length() > 1) {
            String after = text.substring(0, text.length() - 1);
            if (after.endsWith(".")) {
                after = after.substring(0, after.length() - 1);
            }
            if (after.isEmpty() || after.equals("-")) {
                display = "0";
            } else {
                display = after;
            }
        } else {
            display = "0";
        }
        justCalculated = false;
    }

    public void equalsAction() {
        String text = display;
        if (!isNumeric(text)) {
            return;
        }
        if (firstEntered && justCalculated) {
            return;
        }
        if (firstEntered) {
            num2 = Double.parseDouble(text);
            double res;
            switch (oper) {
                case "+": res = num1 + num2; break;
                case "-": res = num1 - num2; break;
                case "*": res = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        display = "Nie można dzielić przez 0";
                        firstEntered = false;
                        oper = "\0";
                        justCalculated = true;
                        return;
                    }
                    res = num1 / num2;
                    break;
                default: return;
            }
            result = res;
            setResultText(res);

            num1 = res;
            firstEntered = false;
            oper = "\0";
            justCalculated = true;
        }
    }

    private void setResultText(double result) {
        if (Math.floor(result) == result) {
            display = String.valueOf((int) result);
        } else {
            display = String.valueOf(result);
        }
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}