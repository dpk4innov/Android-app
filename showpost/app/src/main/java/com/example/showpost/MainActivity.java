package com.example.showpost;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

//import android.widget.Toolbar;
//import android.widget.Toolbar;

public class MainActivity  extends AppCompatActivity {
    private com.example.showpost.DatabaseHelper objectDatabase;
    private RecyclerView objectRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar mtoolbar = findViewById(R.id.toolbar);
       setSupportActionBar(mtoolbar);



        try {
            objectRecyclerView = findViewById(R.id.topicview);
            objectDatabase = new com.example.showpost.DatabaseHelper(this);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        try {
            objectDatabase.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        objectDatabase.openDataBase();

        try{

            mainadapter objectRvAdapter = new mainadapter(this,objectDatabase.gettopicsData());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    //HERE CREATE OPTION SELECTED METHOD REMAINS

        /*public void newact(String s){
        Intent intent=new Intent(MainActivity.this,ShowImagesActivity.class);
        intent.putExtra("key",s);

        startActivity(intent);
    }*/


}