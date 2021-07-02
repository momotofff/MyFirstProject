package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    TextView window;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = findViewById(R.id.window);
        window.setText("0");
        List<Integer> list = new ArrayList<>();
    }

    public void onClickButtonNumber(View v)
    {
        String str = window.getText().toString();
        if(str.equals("0"))
            window.setText(((Button)v).getText().toString());
        else
            window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }

    public void onClickButtonResult(View v)
    {
        List<String> list = new ArrayList<>();
        char[] allValues = (window.getText().toString().toCharArray());
        String oneValue;
        String twoValue;

        for (int i = 0; i < allValues.length; ++i)
        {

        }
        //window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }

    public void onClickButtonDelete(View v)
    {
        window.setText("0");
    }
}