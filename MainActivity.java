package com.example.showpost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView v1=((TextView) findViewById(R.id.t1));
        final TextView v2=((TextView) findViewById(R.id.t2));
        final TextView v3=((TextView) findViewById(R.id.t3));
        final TextView v4=((TextView) findViewById(R.id.t4));
        final TextView v5=((TextView) findViewById(R.id.t5));
        final TextView v6=((TextView) findViewById(R.id.t6));
        final TextView v7=((TextView) findViewById(R.id.t7));
        final TextView v8=((TextView) findViewById(R.id.t8));
        final TextView v9=((TextView) findViewById(R.id.t9));
        final TextView v10=((TextView) findViewById(R.id.t10));
        final TextView v11=((TextView) findViewById(R.id.t11));
        final TextView v12=((TextView) findViewById(R.id.t12));
        final TextView v13=((TextView) findViewById(R.id.t13));
        final TextView v14=((TextView) findViewById(R.id.t14));
        final TextView v15=((TextView) findViewById(R.id.t15));
        final TextView v16=((TextView) findViewById(R.id.t16));
        final TextView v17=((TextView) findViewById(R.id.t17));
        final TextView v18=((TextView) findViewById(R.id.t18));
        final TextView v19=((TextView) findViewById(R.id.t19));





        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                newact("subreddit");
            }
        });



        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                newact("art");
            }
        });



        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v3.getText().toString();
                newact(s);
            }
        });



        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v4.getText().toString();
                newact(s);
            }
        });


        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v5.getText().toString();
                newact(s);
            }
        });


        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v6.getText().toString();
                newact(s);
            }
        });


        v7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v7.getText().toString();
                newact(s);
            }
        });

        v8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v8.getText().toString();
                newact(s);
            }
        });

        v9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v9.getText().toString();
                newact(s);
            }
        });

        v10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v10.getText().toString();
                newact(s);
            }
        });

        v11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v11.getText().toString();
                newact(s);
            }
        });


        v12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v12.getText().toString();
                newact(s);
            }
        });

        v13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v13.getText().toString();
                newact(s);
            }
        });

        v14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v14.getText().toString();
                newact(s);
            }
        });

        v15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v15.getText().toString();
                newact(s);
            }
        });


        v16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v16.getText().toString();
                newact(s);
            }
        });

        v17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v17.getText().toString();
                newact(s);
            }
        });

        v18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v18.getText().toString();
                newact(s);
            }
        });

        v19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                myDbHelper.openDataBase();
                String s=v19.getText().toString();
                newact(s);
            }
        });



    } public void newact(String s){
        Intent intent=new Intent(MainActivity.this,ShowImagesActivity.class);
        intent.putExtra("key",s);

        startActivity(intent);
    }


}