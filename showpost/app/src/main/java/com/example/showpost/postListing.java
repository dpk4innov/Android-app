package com.example.showpost;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

public class postListing extends AppCompatActivity {
    private com.example.showpost.DatabaseHelper objectDatabaseHandler;
    private RecyclerView objectRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postlisting);

        int row_id= getIntent().getIntExtra("text_row",0);

        try {
            objectRecyclerView = findViewById(R.id.imagesRV);
            objectDatabaseHandler = new com.example.showpost.DatabaseHelper(this);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        try {
            objectDatabaseHandler.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        objectDatabaseHandler.openDataBase();

        try{

            RVAdapter objectRvAdapter = new RVAdapter(this,objectDatabaseHandler.getAllImagesData(row_id),row_id);
            objectRecyclerView.setHasFixedSize(true);
            objectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            objectRecyclerView.setAdapter(objectRvAdapter);

        }
        catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        objectRecyclerView.addItemDecoration(divider);







    }


}



