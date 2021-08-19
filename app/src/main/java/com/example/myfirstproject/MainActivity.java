package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity
{
    private TextView window;

    private static final String Zero = "0";
    private static final String TextViewTextKey = "TEXTVIEW_TEXT";
    private static final String DivisionByZero = "Делить на ноль нельзя!!!";
    private static final String Error = "Error";

    private enum Op
    {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVISION,
        SQUAREROOT,
        UNDEFINED,
    }

    private static class Operation
    {
        final public Op value;

        Operation (char ch)
        {
            switch (ch)
            {
                case '+': value = Op.PLUS; break;
                case '-': value = Op.MINUS; break;
                case '*': value = Op.MULTIPLY; break;
                case '/': value = Op.DIVISION; break;
                case '√': value = Op.SQUAREROOT; break;
                default: value = Op.UNDEFINED; break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = findViewById(R.id.window);
        window.setText(Zero);

    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonNumber(View v)
    {
        if (window.getText().equals(DivisionByZero) || window.getText().equals(Error))
            window.setText(Zero);

        String text = window.getText().toString();
        String buttonText = ((Button) v).getText().toString();

        if (Zero.equals(text))
            window.setText(buttonText);
        else
            window.setText(text + buttonText);
    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonOperations(View v)
    {
        if (window.getText().equals(DivisionByZero) || window.getText().equals(Error))
            window.setText(Zero);

        String text = window.getText().toString();
        Operation op = new Operation(text.charAt(text.length() - 1));

        if (op.value == Op.UNDEFINED)
            window.setText(text + " " + ((Button) v).getText().toString() + " ");
    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonResult(View v)
    {
        String[] stringOperations = window.getText().toString().split(" ");
        BigDecimal result = new BigDecimal(stringOperations[0]);

        for (int i = 1; i < stringOperations.length - 1; ++i)
        {
            Operation op = new Operation(stringOperations[i].charAt(0));
            BigDecimal second;

            try
            {
                second = new BigDecimal(stringOperations[i + 1]);

            }
            catch (Exception e)
            {
                window.setText(Zero);
                return;
            }

            if (op.value.equals(Op.PLUS))
                result = result.add(second);

            else if (op.value.equals(Op.MINUS))
                result = result.subtract(second);

            else if (op.value.equals(Op.MULTIPLY))
                result = result.multiply(second);

            else if (op.value.equals(Op.DIVISION))
            {
                if (second.intValue() == 0)
                {
                    window.setText(DivisionByZero);
                    break;
                }
                else
                    result = result.divide(second);
            }

            else if (op.value.equals(Op.SQUAREROOT))
            {
                if (second.intValue() < 0)
                {
                    window.setText(Error);
                    break;
                }
                else
                    result = BigDecimal.valueOf(Math.sqrt(second.doubleValue()));
            }

            i++;
        }

        if (!window.getText().equals(DivisionByZero) && !window.getText().equals(Error))
            window.setText(result.toString());

    }

    public void onClickButtonDelete(View v)
    {
        window.setText(Zero);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView nameView = findViewById(R.id.window);
        outState.putString(TextViewTextKey, nameView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String textViewText= savedInstanceState.getString(TextViewTextKey);
        TextView nameView = findViewById(R.id.window);
        nameView.setText(textViewText);
    }
}