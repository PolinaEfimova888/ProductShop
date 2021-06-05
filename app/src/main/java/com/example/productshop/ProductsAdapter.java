package com.example.productshop;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductsAdapter extends CursorAdapter {
    Picasso p;
    public ProductsAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        p  = new Picasso.Builder(context).build();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.product, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView picture = view.findViewById(R.id.photo);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvColor = view.findViewById(R.id.color);
        TextView tvSize = view.findViewById(R.id.size);
        TextView tvCountry = view.findViewById(R.id.country);

        String name = cursor.getString(cursor.getColumnIndex("name"));
        String color = cursor.getString(cursor.getColumnIndex("color"));
        String size = cursor.getString(cursor.getColumnIndex("size"));
        String country = cursor.getString(cursor.getColumnIndex("country"));

        tvName.setText(name);
        tvColor.setText(color);
        tvSize.setText(size);
        tvCountry.setText(country);

        Uri url = Uri.parse(cursor.getString(cursor.getColumnIndex("url")));
        // image view set picture

        p.load(url).error(R.drawable.no_image).into(picture);
    }
}