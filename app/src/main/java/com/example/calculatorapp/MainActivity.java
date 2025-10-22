package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDisplay;
    private double firstNumber = Double.NaN;
    private double secondNumber;
    private String currentOperator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);
    }

    public void numberEvent(View view) {
        Button btn = (Button) view;
        String value = btn.getText().toString();
        if (isOperatorPressed) {
            txtDisplay.setText("");
            isOperatorPressed = false;
        }
        String currentText = txtDisplay.getText().toString();
        if (currentText.equals("0") && !value.equals(".")) currentText = "";
        txtDisplay.setText(currentText + value);
    }

    public void operatorEvent(View view) {
        Button btn = (Button) view;
        String operator = btn.getText().toString();
        if (!Double.isNaN(firstNumber)) {
            compute();
        } else {
            firstNumber = Double.parseDouble(txtDisplay.getText().toString());
        }
        currentOperator = operator;
        isOperatorPressed = true;
    }

    public void equalEvent(View view) {
        compute();
        txtDisplay.setText(removeTrailingZero(firstNumber));
        currentOperator = "";
    }

    public void sqrtEvent(View view) {
        double value = Double.parseDouble(txtDisplay.getText().toString());
        value = Math.sqrt(value);
        txtDisplay.setText(removeTrailingZero(value));
        firstNumber = value;
    }

    public void reciprocalEvent(View view) {
        double value = Double.parseDouble(txtDisplay.getText().toString());
        if (value != 0) {
            value = 1 / value;
            txtDisplay.setText(removeTrailingZero(value));
            firstNumber = value;
        } else txtDisplay.setText("Error");
    }

    public void signChangeEvent(View view) {
        double value = Double.parseDouble(txtDisplay.getText().toString());
        value = -value;
        txtDisplay.setText(removeTrailingZero(value));
    }

    public void backEvent(View view) {
        String value = txtDisplay.getText().toString();
        if (value.length() > 1)
            txtDisplay.setText(value.substring(0, value.length() - 1));
        else
            txtDisplay.setText("0");
    }

    public void clearEntryEvent(View view) {
        txtDisplay.setText("0");
    }

    public void clearEvent(View view) {
        txtDisplay.setText("0");
        firstNumber = Double.NaN;
        secondNumber = Double.NaN;
        currentOperator = "";
    }

    private void compute() {
        if (Double.isNaN(firstNumber)) return;
        secondNumber = Double.parseDouble(txtDisplay.getText().toString());
        switch (currentOperator) {
            case "+": firstNumber += secondNumber; break;
            case "-": firstNumber -= secondNumber; break;
            case "*": firstNumber *= secondNumber; break;
            case "/":
                if (secondNumber != 0) firstNumber /= secondNumber;
                else { txtDisplay.setText("Error"); firstNumber = Double.NaN; }
                break;
            case "%": firstNumber %= secondNumber; break;
        }
    }

    private String removeTrailingZero(double value) {
        if (value == (long) value)
            return String.format("%d", (long) value);
        else
            return String.format("%s", value);
    }
}