package com.grantyuan.databasetest;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.grantyuan.databasetest.databaseclass.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyDatabaseHelper dbHelper;

    private String newId;

    private Button addData;
    private Button queryData;
    private Button updateData;
    private Button deleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData = (Button)findViewById(R.id.add_data);
        queryData = (Button)findViewById(R.id.query_database);
        updateData = (Button)findViewById(R.id.updata_data);
        deleteData = (Button)findViewById(R.id.delete_data);

        addData.setOnClickListener(this);
        queryData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_data:
                Uri uri = Uri.parse("content://com.grantyuan.databasetest.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martin");
                values.put("pages", 1040);
                values.put("price", 22.85);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
                break;
            default:
                break;
        }
    }
}
