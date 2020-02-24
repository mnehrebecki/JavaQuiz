package com.example.javaquiz;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey
    public Integer id;

    @ColumnInfo(name = "name")
    public String name;
}
