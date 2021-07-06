package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    TextView window;
    String[] stringOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = findViewById(R.id.window);
        window.setText("0");
    }

    public void onClickButtonNumber(View v)
    {
        if (window.getText().toString().equals("0"))
            window.setText(((Button)v).getText().toString());
        else
            window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }

    public void onClickButtonOperations(View v)
    {
        if (window.getText().toString().equals("0"))
            window.setText(window.getText().toString());
        else if (String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 1)).equals("+")
                | String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 1)).equals("-")
                | String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 1)).equals("*"))

                window.setText(window.getText().toString());
        else
                window.setText(window.getText().toString() + " " + ((Button)v).getText().toString() + " ");
    }

    public void onClickButtonResult(View v)
    {
        stringOperations = window.getText().toString().split(" ");
        long res = Integer.parseInt(stringOperations[0]);

        for (int i = 1; i < stringOperations.length - 1; ++i)
        {
            if (stringOperations[i].equals("+"))
            {
                res += Long.parseLong(stringOperations[i + 1]);
            }

            if (stringOperations[i].equals("-"))
            {
                res -= Long.parseLong(stringOperations[i + 1]);
            }
            if (stringOperations[i].equals("*"))
            {
                res *= Long.parseLong(stringOperations[i + 1]);
            }
        }

        window.setText(res + "");
    }

    public void onClickButtonDelete(View v)
    {
        window.setText("0");

    }
}