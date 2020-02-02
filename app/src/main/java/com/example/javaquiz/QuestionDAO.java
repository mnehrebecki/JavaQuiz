package com.example.javaquiz;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface QuestionDAO {
    @Query("SELECT * FROM questions")
    List <Question> getAll();
}
