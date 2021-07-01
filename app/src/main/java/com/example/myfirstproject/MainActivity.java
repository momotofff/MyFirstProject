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
    }

    public void onClickButtonNumber(View v)
    {
        window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }

    public void onClickButtonResult(View v)
    {
        List<Integer> list = new ArrayList<>();


        window.setText(window.getText().toString() + ((Button)v).getText().toString());
    }
}