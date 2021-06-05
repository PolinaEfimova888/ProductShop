package com.example.productshop;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ProductDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.product_listview);
        db = ProductDB.create(this, false);

        Cursor cursor = db.query("SELECT * FROM product", null);

        ProductsAdapter adapter = new ProductsAdapter(this, cursor, 0);
        lv.setAdapter(adapter);
    }
}