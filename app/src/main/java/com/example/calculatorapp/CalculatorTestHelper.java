package com.example.calculatorapp;

public class CalculatorTestHelper {

    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0.0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return firstNumber / secondNumber;
    }

    public static double percent(double base, double percent) {
        return base * percent / 100.0;
    }

    public static double reciprocal(double value) {
        if (value == 0.0) {
            throw new IllegalArgumentException("Cannot calculate reciprocal of zero");
        }
        return 1.0 / value;
    }

    public static double negate(double value) {
        return -value;
    }

    public static String formatResult(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.format("%s", value);
        }
    }
}
