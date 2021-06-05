package com.example.productshop;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Locale;

@Entity(tableName = "product")
public class Product {
    @PrimaryKey
    @NonNull
    int _id;
    @NonNull
    String url, name, color, size, country;

    public Product(int _id, @NonNull String url, @NonNull String name,
                   @NonNull String color, @NonNull String size,
                   @NonNull String country) {
        this._id = _id;
        this.url = url;
        this.name = name;
        this.color = color;
        this.size = size;
        this.country = country;
    }

}