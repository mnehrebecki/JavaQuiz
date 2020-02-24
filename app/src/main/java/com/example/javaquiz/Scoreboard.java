package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Scoreboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        List<Score> scoreList;
        QuizDB db = QuizDB.getInstance(this);
        scoreList = db.scoreDAO().getAll();
        RecyclerView scoreboard =  findViewById(R.id.rvscoreboard);
        scoreboard.setLayoutManager(new LinearLayoutManager(this));
        ScoreboardAdapter adapter = new ScoreboardAdapter(scoreList);
        scoreboard.setHasFixedSize(true);
        scoreboard.setAdapter(adapter);
    }
}
