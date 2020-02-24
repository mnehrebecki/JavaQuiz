package com.example.javaquiz;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface QuestionDAO {
    @Query("SELECT * FROM questions")
    List <Question> getAll();

    @Query("SELECT * FROM questions where categoryId =:catId ")
    List<Question> getQuestions(int catId);
}
