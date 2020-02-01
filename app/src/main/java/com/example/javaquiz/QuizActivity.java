package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvQuestionCunter;
    private TextView tvTimeCounter;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button brnConfirm;

    private List<Question> qlist;
    private int questionCounter;
    private int totalQuestions;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.question);
        tvQuestionCunter = findViewById(R.id.view_quest_count);
        tvTimeCounter = findViewById(R.id.counter);
        radioGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        brnConfirm = findViewById(R.id.btn_confirm);

        //inicjalizacja BD
        QuizDB db = QuizDB.getInstance(this);
        qlist = db.questionDAO().getAll();

        totalQuestions = qlist.size();
        Collections.shuffle(qlist);

        ShowNextQuestion();


    }

    private void ShowNextQuestion(){

    }
}
