package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvScore;
    private TextView tvQuestion;
    private TextView tvQuestionCunter;
    private TextView tvTimeCounter;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private Button btnConfirm;

    private TextView odpzbazy;
    private TextView opwyznaczona;

    private List<Question> qlist;
    private int questionCounter;
    private int totalQuestions;
    private int score = 0;
    private Question currQuestion;
    private Boolean isAnswered;
    private String combinedAnswer = new String("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvScore = findViewById(R.id.score);
        tvQuestion = findViewById(R.id.question);
        tvQuestionCunter = findViewById(R.id.view_quest_count);
        tvTimeCounter = findViewById(R.id.counter);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        btnConfirm = findViewById(R.id.btn_confirm);

        odpzbazy =findViewById(R.id.odpzbazy);
        opwyznaczona = findViewById(R.id.odpwyznaczona);

        //inicjalizacja BD
        QuizDB db = QuizDB.getInstance(this);
        qlist = db.questionDAO().getAll();

        totalQuestions = qlist.size();
        Collections.shuffle(qlist);

        ShowNextQuestion();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
                        checkAnswer();
                        ShowNextQuestion();

                    }
                    else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                }

        });


    }

    private void ShowNextQuestion(){
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);

        if(questionCounter<totalQuestions){
            currQuestion = qlist.get(questionCounter);
            tvQuestion.setText(currQuestion.question);
            cb1.setText(currQuestion.odp1);
            cb2.setText(currQuestion.odp2);
            cb3.setText(currQuestion.odp3);
            cb4.setText(currQuestion.odp4);

            questionCounter++;
            tvQuestionCunter.setText("Pytanie: "+questionCounter+"/"+totalQuestions);
            isAnswered = false;

        }
        else{
            finish();
        }
    }

    private void checkAnswer(){
        isAnswered = true;
        String qAnswer = currQuestion.answer;
        if(cb1.isChecked()){
            combinedAnswer+="1";
        }else {
            combinedAnswer+="0";
        }
        if(cb2.isChecked()){
            combinedAnswer+="1";
        }else {
            combinedAnswer+="0";
        }
        if(cb3.isChecked()){
            combinedAnswer+="1";
        }else {
            combinedAnswer+="0";
        }
        if(cb4.isChecked()){
            combinedAnswer+="1";
        }else {
            combinedAnswer+="0";
        }
        odpzbazy.setText(qAnswer);
        opwyznaczona.setText(combinedAnswer);

        if(qAnswer.equals(combinedAnswer)) {
            score++;
            tvScore.setText("Wynik: "+ score);
        }
        else {
            tvScore.setText("Wynik: "+ score);
        }
        combinedAnswer="";
    }
}