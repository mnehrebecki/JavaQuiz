package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStartQuiz = findViewById(R.id.button_start_quiz);
        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBeforeStart();
            }
        });

    }
    private void openBeforeStart()
    {
        Intent open_before_start = new Intent(MainActivity.this, BeforeStart.class);
        startActivity(open_before_start);
    }

}
