package com.example.showpost;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowImagesActivity extends AppCompatActivity {
    private com.example.showpost.DatabaseHelper objectDatabaseHandler;
    private RecyclerView objectRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images);
        String table_name= getIntent().getStringExtra("key");

        try {
            objectRecyclerView = findViewById(R.id.imagesRV);
            objectDatabaseHandler = new com.example.showpost.DatabaseHelper(this);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        try{

            RVAdapter objectRvAdapter = new RVAdapter(this,objectDatabaseHandler.getAllImagesData(table_name),table_name);
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



