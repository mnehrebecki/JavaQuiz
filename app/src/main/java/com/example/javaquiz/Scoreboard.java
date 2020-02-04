package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    ListView scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        List<Score> scoreList;
        QuizDB db = QuizDB.getInstance(this);
        scoreList = db.scoreDAO().getAll();
        RecyclerView scoreboard =  findViewById(R.id.rvscoreboard);
        scoreboard.setLayoutManager(new LinearLayoutManager(this));
        MyListAdapter adapter = new MyListAdapter(scoreList);
        scoreboard.setHasFixedSize(true);
        scoreboard.setAdapter(adapter);
    }
}
