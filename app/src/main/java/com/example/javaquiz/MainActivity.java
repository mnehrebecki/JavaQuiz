package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnResults = findViewById(R.id.button_results);
        Button btnStartQuiz = findViewById(R.id.button_start_quiz);
        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBeforeStart();
            }
        });
        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScoreboard();
            }
        });

    }
    private void openBeforeStart()
    {
        Intent open_before_start = new Intent(MainActivity.this, BeforeStart.class);
        startActivity(open_before_start);
    }
    private void openScoreboard()
    {
        Intent open_scoreboard = new Intent(MainActivity.this, Scoreboard.class);
        startActivity(open_scoreboard);
    }

}
