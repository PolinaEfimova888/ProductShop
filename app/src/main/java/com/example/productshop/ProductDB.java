package com.example.productshop;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={Product.class}, version=2)
public abstract class ProductDB extends RoomDatabase {
    abstract DaoObiect dao_obiect();

    private static final String DB_NAME = "product.db";
    private static volatile com.example.productshop.ProductDB INSTANCE = null;

    synchronized static com.example.productshop.ProductDB get(Context ctxt) {

        if (INSTANCE == null) {
            INSTANCE = create(ctxt, false);
        }
        return (INSTANCE);
    }

    static com.example.productshop.ProductDB create(Context ctxt, boolean memoryOnly) {
        RoomDatabase.Builder<com.example.productshop.ProductDB> b;
        if (memoryOnly) {
            b = Room.inMemoryDatabaseBuilder(ctxt.getApplicationContext(),
                    com.example.productshop.ProductDB.class);
        } else {
            b = Room.databaseBuilder(ctxt.getApplicationContext(), com.example.productshop.ProductDB.class,
                    DB_NAME);
        }
        return (b.createFromAsset("pic_db.db").build());

    }
}