package com.grantyuan.filepersistencetest.utils;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Grantyuan on 2017/10/19.
 */

public class PrivateDataUtils {
    private String TAG = "PrivateDataUtils";

    public void save(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
//            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            Log.d(TAG, "save: " + e.toString());
        }finally {
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                Log.d(TAG, "save: " + e.toString());
            }
        }
        return;
    }
}
