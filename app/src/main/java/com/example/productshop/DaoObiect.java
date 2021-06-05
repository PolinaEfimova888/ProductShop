package com.example.productshop;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoObiect {
    @Query("SELECT * FROM product")
    List<Product> selectAll();
}
