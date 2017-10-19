package com.grantyuan.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button savaData = (Button) findViewById(R.id.sava_data);
        Button restoreData = (Button) findViewById(R.id.restore_data);

        savaData.setOnClickListener(this);
        restoreData.setOnClickListener(this);
    }


    @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.restore_data:
                    SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                    String name = preferences.getString("name", "");
                    int age = preferences.getInt("age", 0);
                    boolean married = preferences.getBoolean("married", false);
                    Toast.makeText(MainActivity.this, "name=" + name + "; age=" + age + "; married=" + married,
                            Toast.LENGTH_SHORT).show();
                    break;

                case R.id.sava_data:
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("name", "Tome");
                    editor.putInt("age", 28);
                    editor.putBoolean("married", false);
                    editor.apply();
                    break;
                default:
                    break;
            }
        }

}
