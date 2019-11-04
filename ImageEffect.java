package com.example.showpost;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ImageEffect extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagezoom);

        com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(ImageEffect.this);
        try {

            myDbHelper.createDataBase();
        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }
        SQLiteDatabase mydb;
        mydb = myDbHelper.openDataBase();

        int id = getIntent().getIntExtra("img_row",0);
        String table2=getIntent().getStringExtra("img_table");


        Cursor cursor = mydb.rawQuery(" select * from "+table2,null);

        if(cursor != null && cursor.getCount() > 0)
        {
            cursor.moveToPosition(id);
        }



        byte[] imageBytes = cursor.getBlob(2);
        Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        cursor.close();
        ImageView image = findViewById(R.id.im1);
        image.setImageBitmap(objectBitmap);

    }


}