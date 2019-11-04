package com.example.showpost;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class display  extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(display.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        SQLiteDatabase mydb;
        mydb=myDbHelper.openDataBase();
        int id=getIntent().getIntExtra("text_row",0);
        String table3=getIntent().getStringExtra("text_table");

        Cursor cursor = mydb.rawQuery(" select *from "+table3,null);
        if(cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToPosition(id);
        }

        String data=cursor.getString(1);
        cursor.close();
        TextView textView=findViewById(R.id.text2);
        textView.setText(data);

    }
}
