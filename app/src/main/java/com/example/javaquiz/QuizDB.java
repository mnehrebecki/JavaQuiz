package com.example.javaquiz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Question.class},version = 1)
public abstract class QuizDB extends RoomDatabase {
    private static final String DB_NAME = "javaQuiz1.db";
    private static QuizDB instance;

    public static synchronized QuizDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),QuizDB.class,DB_NAME)
                    .createFromAsset("database/javaQuiz.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }



    public abstract QuestionDAO questionDAO();
}
