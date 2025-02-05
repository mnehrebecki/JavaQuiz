package com.example.javaquiz;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories")
    List<Category> getAll();
}
