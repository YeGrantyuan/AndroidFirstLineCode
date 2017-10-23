package com.grantyuan.litepaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.grantyuan.litepaltest.utils.Book;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button createDatabase;
    private Button addData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        Button addData = (Button) findViewById(R.id.add_database);

        createDatabase.setOnClickListener(this);
        addData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (v.getId()) {
            case R.id.add_database:
                Book book = new Book();
                book.setName("The Da Vinci code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrices(16.99);
                book.setPress("Unknow");
                book.save();
                break;
            case R.id.updata_database:

                break;

            default:
                break;

        }
    }
}
