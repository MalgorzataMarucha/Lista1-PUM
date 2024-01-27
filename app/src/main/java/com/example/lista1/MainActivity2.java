package com.example.lista1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView congratulation, points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        congratulation = findViewById(R.id.questNum);
        points = findViewById(R.id.points);

        if (congratulation != null) {
            congratulation.setText("Gratulacje!");
        }

        if (points != null)
            points.setText("Zdobyłeś "+ String.valueOf(score)+"/100 pkt");
    }
}