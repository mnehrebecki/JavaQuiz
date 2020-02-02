package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EndGameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_screen);
        Button btnBackToMenu = findViewById(R.id.btn_back_to_menu);
        Bundle getScoreBundle = getIntent().getExtras();
        Integer gotScore = getScoreBundle.getInt("score");
        TextView showScore = findViewById(R.id.tvScore);
        showScore.setText(gotScore.toString());

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuScreen();
            }
        });

    }

    private void openMenuScreen() {
        Intent open_menu_screen = new Intent(EndGameScreen.this,MainActivity.class);
        startActivity(open_menu_screen);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Naciśnij przycisk aby wyjść", Toast.LENGTH_SHORT).show();

    }
}
