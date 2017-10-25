package com.grantyuan.runtimepermissiontest.utils;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Administrator on 2017/10/25.
 */

public class UtilsClass {
    private String TAG = "UtilsClass";
    public void call(){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            //startActivity(intent);
        }catch (SecurityException e){
            Log.d(TAG, "e.toString()");
        }
    }
}
