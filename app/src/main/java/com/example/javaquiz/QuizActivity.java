package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    private static final long COUNTDOWN_IN_MILL = 30000;
    private TextView tvQuestion;
    private TextView tvQuestionCunter;
    private TextView tvTimeCounter;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private ImageView questionImg;
    private Score playerScore = new Score(null,"",0);
    private List<Question> qlist;
    private int questionCounter;
    private int totalQuestions;
    private int score = 0;
    private int catId;
    private CountDownTimer timer;
    private long timeLeft;
    private Question currQuestion;
    private String combinedAnswer = new String("");
    Bundle scoreBundle = new Bundle();
    QuizDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //inicjalizacja BD
        db = QuizDB.getInstance(this);

        tvQuestion = findViewById(R.id.question);
        tvQuestionCunter = findViewById(R.id.view_quest_count);
        tvTimeCounter = findViewById(R.id.counter);
        questionImg = findViewById(R.id.questionImage);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        Button btnConfirm = findViewById(R.id.btn_confirm);
        String gotName;
        Bundle gotNameBundle = getIntent().getExtras();
        gotName = gotNameBundle.getString("playerName");
        int gotCategoryId  = gotNameBundle.getInt("categoryId");
        playerScore.name=gotName;

        if(gotCategoryId==1) {
            qlist = db.questionDAO().getAll();
        }
        else{
            qlist = db.questionDAO().getQuestions(gotCategoryId);
        }

        totalQuestions = qlist.size();
        Collections.shuffle(qlist);

        ShowNextQuestion();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
                    checkAnswer();
                    ShowNextQuestion();
                } else {
                    Toast.makeText(QuizActivity.this, "Zaznacz odpowiedź", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    private void ShowNextQuestion() {
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);

        if (questionCounter < totalQuestions) {
            currQuestion = qlist.get(questionCounter);

                if (currQuestion.img.equals("empty")) {
                    questionImg.setVisibility(View.GONE);
                } else {
                    questionImg.setVisibility(View.VISIBLE);
                    questionImg.setImageResource(this.getResources().getIdentifier(currQuestion.img, "drawable", "com.example.javaquiz"));
                }

                tvQuestion.setText(currQuestion.question);
                cb1.setText(currQuestion.odp1);
                cb2.setText(currQuestion.odp2);
                cb3.setText(currQuestion.odp3);
                cb4.setText(currQuestion.odp4);

                questionCounter++;
                tvQuestionCunter.setText("Pytanie: " + questionCounter + "/" + totalQuestions);

                timeLeft = COUNTDOWN_IN_MILL;
                startTimer();

        } else {
            scoreBundle.putInt("score", score);
            if(score>0) {
                playerScore.score = score;
                db.scoreDAO().insertScore(playerScore);
            }
            openEndGameScreen();
        }
    }
    private void startTimer(){
        timer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateCounter();
            }

            @Override
            public void onFinish() {
                timeLeft = 0;
                updateCounter();
                checkAnswer();
                ShowNextQuestion();
            }
        }.start();

    }
    private void updateCounter(){
        int minutes =0;
        int seconds = (int) (timeLeft / 1000);

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tvTimeCounter.setText(timeFormatted);

        if (timeLeft < 10000) {
            tvTimeCounter.setTextColor(Color.RED);
        } else {
            tvTimeCounter.setTextColor(Color.BLACK);
        }
    }

    private void openEndGameScreen() {
        Intent open_end_game_screen = new Intent(QuizActivity.this, EndGameScreen.class);
        open_end_game_screen.putExtras(scoreBundle);
        startActivity(open_end_game_screen);
    }

    private void checkAnswer() {
        timer.cancel();
        String qAnswer = currQuestion.answer;
        if (cb1.isChecked()) {
            combinedAnswer += "1";
        } else {
            combinedAnswer += "0";
        }
        if (cb2.isChecked()) {
            combinedAnswer += "1";
        } else {
            combinedAnswer += "0";
        }
        if (cb3.isChecked()) {
            combinedAnswer += "1";
        } else {
            combinedAnswer += "0";
        }
        if (cb4.isChecked()) {
            combinedAnswer += "1";
        } else {
            combinedAnswer += "0";
        }

        if (qAnswer.equals(combinedAnswer)) {
            score++;
        }

        combinedAnswer = "";
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Ukończ quiz aby wyjść", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}