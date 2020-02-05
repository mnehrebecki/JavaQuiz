package com.example.javaquiz;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey
    public  Integer id;

    @ColumnInfo(name = "question")
    public String question;

    @ColumnInfo(name = "odp1")
    public String odp1;

    @ColumnInfo(name = "odp2")
    public String odp2;

    @ColumnInfo(name = "odp3")
    public String odp3;

    @ColumnInfo(name = "odp4")
    public String odp4;

    @ColumnInfo(name = "answer")
    public String answer;

    @ColumnInfo(name = "img")
    public String img;

    @ColumnInfo(name = "categoryId")
    public Integer categoryId;
}
