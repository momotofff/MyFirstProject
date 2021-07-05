package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    TextView window;
    int list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = findViewById(R.id.window);
        window.setText("0");
        list = 0;
    }

    public void onClickButtonNumber(View v)
    {
        String str = window.getText().toString();
        if(str.equals("0") | str.equals("+") | str.equals("-"))
            window.setText(((Button)v).getText().toString());
        else
            window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }

    public void onClickButtonPlus(View v)
    {
        int oui = Integer.parseInt(window.getText().toString()) + list;
        list = oui;
        window.setText("+");
    }

    public void onClickButtonResult(View v)
    {
        window.setText(list + "");
    }

    public void onClickButtonDelete(View v)
    {
        list = 0;
        window.setText("0");
    }
}