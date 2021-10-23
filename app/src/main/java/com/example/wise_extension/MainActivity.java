package com.example.wise_extension;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    public static double buget;
    public static double period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextPage = (Button) findViewById(R.id.nextButton);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Buget = (EditText) findViewById(R.id.BugetPlainText);
                EditText Period = (EditText) findViewById(R.id.PeriodOfBugetPlainText);
                String price = Buget.getText().toString();
                buget = Integer.parseInt(price);
                price = Period.getText().toString();
                period = Integer.parseInt(price);
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });


    }
}