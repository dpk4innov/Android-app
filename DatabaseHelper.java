package com.example.showpost;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    String DB_PATH =null;
    private static String DB_NAME = "mydatabase";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";



        Log.e("Path 1", DB_PATH);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            Toast.makeText(myContext,"No Existing Database",Toast.LENGTH_SHORT).show();
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH+DB_NAME ;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public SQLiteDatabase openDataBase() throws SQLException {
        String myPath = DB_PATH+DB_NAME ;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        return myDataBase;
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
               copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }

   /* public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("post", null, null, null, null, null, null);
    }*/


    /*public String getdata() {


        String selectQuery = "SELECT  * FROM " + "post"+";";
        myDataBase = this.getReadableDatabase();
        Cursor cursor      = myDataBase.rawQuery(selectQuery, null);
        String data = "";

        if(cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToFirst();
            do {
              data= data + "\n"+cursor.getString(1);
            } while (cursor.moveToNext());
        }


        cursor.close();
        return data;
    }*/

    public ArrayList<com.example.showpost.ModelClass> getAllImagesData(String table_name ){
        try{

            myDataBase = this.getReadableDatabase();
            ArrayList<com.example.showpost.ModelClass>objectModelClassList = new ArrayList<>();
            Cursor objectCursor = myDataBase.rawQuery("select * from "+table_name,null);

            if(objectCursor!=null && objectCursor.getCount()>0){
                while (objectCursor.moveToNext()) {
                    String nameOfImage = objectCursor.getString(1);
                    byte[] imageBytes = objectCursor.getBlob(2);
                    Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                    objectModelClassList.add(new com.example.showpost.ModelClass(nameOfImage,objectBitmap));
                }
                return objectModelClassList;
            }
            else{
                Toast.makeText(myContext,"No value Exists in Database",Toast.LENGTH_SHORT).show();
                return null;
            }
        }catch (Exception e){
            Toast.makeText(myContext,e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}