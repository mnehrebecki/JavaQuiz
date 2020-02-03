package com.example.javaquiz;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scores")
public class Score {
    @PrimaryKey(autoGenerate = true)
    public  Integer id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "score")
    public Integer score;

    public Score(Integer id,String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}

