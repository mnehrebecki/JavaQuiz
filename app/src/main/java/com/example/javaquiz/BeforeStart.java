package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BeforeStart extends AppCompatActivity {
    Bundle nameBundle = new Bundle();
    String name = new String("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_start);
        Button btn_start_game = findViewById(R.id.button_start_game);
        final EditText editName = findViewById(R.id.editName);

        btn_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();

                if(name.isEmpty()) {
                    Toast.makeText(BeforeStart.this, "Wpisz imię", Toast.LENGTH_SHORT).show();
                }else {
                    nameBundle.putString("playerName",name);
                    startGame();
                }
            }
        });
    }

    private void startGame() {
        Intent start_game = new Intent(BeforeStart.this, QuizActivity.class);
        start_game.putExtras(nameBundle);
        startActivity(start_game);
    }
}
