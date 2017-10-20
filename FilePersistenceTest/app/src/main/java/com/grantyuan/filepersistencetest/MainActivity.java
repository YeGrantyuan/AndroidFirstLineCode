package com.grantyuan.filepersistencetest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.grantyuan.filepersistencetest.utils.PrivateDataUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private EditText editText;
    PrivateDataUtils privateDataUtils = new PrivateDataUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        String inputText = load();
        if(!TextUtils.isEmpty(inputText)){
            editText.setText(inputText);
            editText.setSelection(inputText.length());
            Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = editText.getText().toString();
        save(inputText);

    }

    public void save(String inputText) {
        FileOutputStream out;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            Log.d(TAG, "save: " + e.toString());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                Log.d(TAG, "save: " + e.toString());
            }
        }
    }

    public String load() {
        FileInputStream in;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }catch (IOException e) {
            Log.d(TAG, "load: " + e.toString());
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    Log.d(TAG, "load: " + e.toString());
                }
            }
        }
        return content.toString();
    }

}
