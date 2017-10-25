package com.grantyuan.contactstest.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Grantyuan on 2017/10/25.
 */

public class SelfProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;
    public static final int TABLE1_ITEM = 1;
    public static final int TABLE2_DIR = 3;
    public static final int TABLE2_ITEM = 4;
    private static UriMatcher uriMatcher;
    private static String appAuthority = "com.grantyuan.contactstest.provider";

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(appAuthority, "table1", TABLE1_DIR);
        uriMatcher.addURI(appAuthority, "table1/#", TABLE1_ITEM);
        uriMatcher.addURI(appAuthority, "table2", TABLE2_DIR);
        uriMatcher.addURI(appAuthority, "table2/#", TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                //Query all data in table1
                break;
            case TABLE1_ITEM:
                //Query single data in table1
                break;
            case TABLE2_DIR:
                //Query all data in table2
                break;
            case TABLE2_ITEM:
                //Query single data in table2
                break;
            default:
                break;
        }
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.grantyuan.contactstest.provider.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.grantyuan.contactstest.provider.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.grantyuan.contactstest.provider.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.grantyuan.contactstest.provider.table2";
            default:break;
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
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
