package com.example.myfirstproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.math.BigDecimal;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    TextView window;
    String[] stringOperations;
    BigDecimal bg;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = findViewById(R.id.window);
        window.setText("0");
        bg = new BigDecimal("");

    }

    public void onClickButtonNumber(View v)
    {
        if (window.getText().toString().equals("0"))
            window.setText(((Button)v).getText().toString());
        else
            window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }

    public void onClickButtonPlus(View v)
    {
        if (window.getText().toString().equals("0"))
            window.setText(window.getText().toString());
        else if (String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 2)).equals("+")
                | String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 2)).equals("-"))
                window.setText(window.getText().toString());
        else
                window.setText(window.getText().toString() + " " + ((Button)v).getText().toString() + " ");
    }

    public void onClickButtonMinus(View v)
    {
        if (window.getText().toString().equals("0"))
            window.setText(window.getText().toString());
        else if (String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 2)).equals("+")
                | String.valueOf((window.getText().toString()).charAt(window.getText().toString().length() - 2)).equals("-"))
                window.setText(window.getText().toString());
        else
                window.setText(window.getText().toString() + " " + ((Button)v).getText().toString() + " ");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickButtonResult(View v)
    {
        stringOperations = window.getText().toString().split(" ");

        for (int i = 1; i < stringOperations.length; i++)
        {
            bg = BigDecimal.valueOf(Double.parseDouble(stringOperations[0]));
        }

    }

    public void onClickButtonDelete(View v)
    {
        window.setText("0");

    }
}