package com.example.showpost;

import android.app.PendingIntent;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;

import static androidx.core.app.NotificationCompat.Builder;
import static androidx.core.app.NotificationCompat.PRIORITY_DEFAULT;

public class contender extends ContentProvider {


    private final String CHANNEL_ID = "Hii_Amol_Here";
    private final int  NOTIFICATION_ID = 001;


    public static final String AUTHORITY="com.example.showpost.mydatabase";
    public static final String PATH="/subreddit";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
   // private static final String table_name="art";
    private DatabaseHelper mydb;



    @Override
    public boolean onCreate() {
        mydb=new DatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    public void displayNotification(){
        Intent intent = new Intent(this.getContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this.getContext(),100,intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Builder builder = new Builder(this.getContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("DatabaseApp");
        builder.setContentText("Happy Birthday Google");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setPriority(PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this.getContext());
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }



    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        displayNotification();
        SQLiteDatabase db=mydb.getWritableDatabase();
        String topic_name=contentValues.getAsString("topic_name");
        //Cursor cursor = db.rawQuery(" select *from topics where topic_name="+topic_name,null);
       // int topic_id=cursor.getInt(0);
        long topic_id= DatabaseUtils.longForQuery(db,"select topic_id from topics where topic_name"+"=?;", new String[]{ topic_name});
        contentValues.remove("topic_name");
        contentValues.put("topic_id",(int)topic_id);
        long row_id=db.insert("posts",null,contentValues);
        db.close();

        Toast.makeText(getContext(),"data inserted", Toast.LENGTH_SHORT).show();
        if(row_id> 0) {
            Uri articleUri = ContentUris.withAppendedId(CONTENT_URI, row_id);
            getContext().getContentResolver().notifyChange(articleUri, null);
            return articleUri;
        }

        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}