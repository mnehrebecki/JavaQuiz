package com.example.javaquiz;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ScoreDAO {
    @Query("SELECT * FROM scores Order by score desc")
    List<Score> getAll();

    @Insert
    void insertScore(Score score);
}
