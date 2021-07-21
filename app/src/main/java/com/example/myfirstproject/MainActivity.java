package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    private TextView window;
    private static final String Zero = "0";

    private enum Op
    {
        PLUS,
        MINUS,
        MULTIPLY,
        UNDEFINED,
    }

    private class Operation
    {
        final public Op value;

        Operation (char ch)
        {
            switch (ch)
            {
                case '+': value = Op.PLUS; break;
                case '-': value = Op.MINUS; break;
                case '*': value = Op.MULTIPLY; break;
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

    public void onClickButtonNumber(View v)
    {
        String text = window.getText().toString();
        String buttonText = ((Button) v).getText().toString();

        if (Zero.equals(text))
            window.setText(buttonText);
        else
            window.setText(text + buttonText);
    }

    public void onClickButtonOperations(View v)
    {
        String text = window.getText().toString();
        Operation op = new Operation(text.charAt(text.length() - 1));

        if (op.value == Op.UNDEFINED)
            window.setText(text + " " + ((Button) v).getText().toString() + " ");
    }

    public void onClickButtonResult(View v)
    {
        String[] stringOperations = window.getText().toString().split(" ");

        Long result = Long.parseLong(stringOperations[0]);

        for (int i = 1; i < stringOperations.length - 1; ++i)
        {
            Operation op = new Operation(stringOperations[i].charAt(0));
            long second;

            try
            {
                second = Long.parseLong(stringOperations[i + 1]);
            }
            catch (Exception e)
            {
                window.setText(Zero);
                return;
            }

            switch (op.value)
            {
                case PLUS:      result += second; break;
                case MINUS:     result -= second; break;
                case MULTIPLY:  result *= second; break;
            }
        }

        window.setText(result.toString());
    }

    public void onClickButtonDelete(View v)
    {
        window.setText(Zero);
    }
}