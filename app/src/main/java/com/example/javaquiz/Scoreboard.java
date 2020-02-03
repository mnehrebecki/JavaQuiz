package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    ListView scoreboard;
    List<Score> scoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        QuizDB db = QuizDB.getInstance(this);
        scoreList = db.scoreDAO().getAll();
        scoreboard = findViewById(R.id.scoreboard);
        ArrayList<String> arrayListScores = new ArrayList<>();
        for (int i = 0; i<scoreList.size();i++){
            arrayListScores.add(String.format("%d. %s  %d",i+1, scoreList.get(i).name , scoreList.get(i).score));
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayListScores);

        scoreboard.setAdapter(adapter);
    }
}
