package com.example.administrator.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ProviderActivity extends BaseActivity {

    private static final String TAG = "ProviderActivity";
    private String newId;

    public static void actionStart(Context context){
        Intent intent = new Intent(context, ProviderActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        TitleLayout titleLayout = (TitleLayout) findViewById(R.id.myTitleLayout);
        titleLayout.setTitle("内容提供者");

        Button addData = (Button) findViewById(R.id.add_data);
        Button updateData = (Button) findViewById(R.id.update_data);
        Button deleteData = (Button) findViewById(R.id.delete_data);
        Button queryData = (Button) findViewById(R.id.query_data);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.administrator.myapplication.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash Of Kings");
                values.put("author", "George Martin");
                values.put("pages", "1040");
                values.put("price", "22.85");
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.administrator.myapplication.provider/book/" + newId);
                ContentValues values = new ContentValues();
                values.put("name", "A Storm Of Swords");
                values.put("pages", "1216");
                values.put("price", "24.05");
                getContentResolver().update(uri, values, null, null);
                Log.d(TAG, "更新数据");
            }
        });

        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.administrator.myapplication.provider/book/" + newId);
                getContentResolver().delete(uri, null, null);
                Log.d(TAG, "删除数据");
            }
        });

        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.administrator.myapplication.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                if (cursor != null){
                    while (cursor.moveToNext()){
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "书名是：" + name);
                        Log.d(TAG, "作者是：" + author);
                        Log.d(TAG, "页数是：" + pages);
                        Log.d(TAG, "价格是：" + price);
                    }
                    cursor.close();
                }
            }
        });
    }
}
