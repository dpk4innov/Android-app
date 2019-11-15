package com.example.showpost;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class display  extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        // Toolbar mtoolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(mtoolbar);

        com.example.showpost.DatabaseHelper myDbHelper = new com.example.showpost.DatabaseHelper(display.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        SQLiteDatabase mydb;
        mydb=myDbHelper.openDataBase();
        int post_id1=getIntent().getIntExtra("text_row",0);
        int topic_id1=getIntent().getIntExtra("text_table",0);

        Cursor cursor = mydb.rawQuery(" select *from posts",null);
        Cursor cursor1 = mydb.rawQuery("select * from topics",null);

        if(cursor!=null && cursor.getCount() > 0)
        {
            cursor.moveToPosition(post_id1-1);
        }


        String data = cursor.getString(2);

        cursor.close();

      /*  TextView textView=findViewById(R.id.text2);
        textView.setText(data);


        if(cursor1 !=null && cursor1.getCount()>0)
        {
            cursor1.moveToPosition(topic_id1-1);
        }
        String result1 = cursor1.getString(1);
        cursor1.close();
        Toolbar mtoolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar1);
        mtoolbar1.setTitle(result1+"/Info");*/
        String data1 = "<HTML>\n" +
                "\n" +
                "<BODY BGCOLOR=\"FFFFFF\">\n" +
                "\n" +
                "Pune University\n" +
                "\n" +
                "<H1>This is a Header</H1>\n" +
                "\n" +
                "<H2>This is a Medium Header</H2>\n" +
                "<br>\n" +
                "\n" +
                "<IMG SRC=\"file:///android_asset/rem.png\" ALIGN=\"BOTTOM \" alt =\"image\" width =50 height = 50>\n" +
                "\n" +
                "Send me mail at <a href=\"mailto:support@yourcompany.com\">\n" +
                "\n" +
                "support@yourcompany.com</a>.\n" +
                "\n" +
                "<P> This is a new paragraph!\n" +
                "\n" +
                "<IMG SRC=\"file:///android_asset/dow.png\" ALIGN=\"BOTTOM \" alt =\"image\" width =50 height = 50>\n"+"\n" +

                "<P> <B>This is a new paragraph!</B>\n" +
                "\n" +
                "<BR> <B><I>This is a new sentence without a paragraph break, in bold italics.</I></B>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "</BODY>\n" +
                "\n" +
                "</HTML>\n";

        WebView web = findViewById(R.id.w2);

        // web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        Document document = Jsoup.parse(data);

        Elements imgtag = document.select("img");
        for (Element element :imgtag)
        {
            String key = element.attr("src");
            Cursor img_cur=mydb.rawQuery("select *from image",null);

            if(img_cur!=null && img_cur.getCount() > 0)
            {
                img_cur.moveToPosition((Integer.parseInt(key))-1);
            }

            byte[] image=img_cur.getBlob(2);
            Bitmap bitmap1 = BitmapFactory.decodeByteArray(image, 0, image.length);
            img_cur.moveToFirst();
            img_cur.close();

            String name = save(bitmap1,key);
            element.attr("src","file:///data/data/com.example.showpost/app_images/image"+key+".jpg");

        }

        String str = document.toString();
        web.loadDataWithBaseURL("",str,"text/html", "UTF-8","");
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setSupportZoom(true);
        web.getSettings().setDomStorageEnabled(true);
        // web.getSettings().setAppCacheEnabled(true);
        // web.getSettings().setMixedContentMode(web.getSettings().MIXED_CONTENT_ALWAYS_ALLOW);
        web.getSettings().setBuiltInZoomControls(true);


    }
    public String save(Bitmap bitmap,String str){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("images", Context.MODE_PRIVATE);
        File file = new File(directory, "image"+str+".jpg");

        if (!file.exists()) {
            Log.d("path", file.toString());
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return file.toString();
    }

    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2,menu);
        return super.onCreateOptionsMenu(menu);

    }

    /public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                // // Toast.makeText(this, "Front Page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Sign:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                break;

            case R.id.like:
                //Toast.makeText(this."No Account",Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Added in Favourites", Toast.LENGTH_SHORT).show();
                break;

            case R.id.remove:
                Toast.makeText(this, "Remove from Favourites", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);

    }*/
}

