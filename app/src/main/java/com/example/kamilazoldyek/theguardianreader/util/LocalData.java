package com.example.kamilazoldyek.theguardianreader.util;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalData {

    private static final String APP_SHARED_PREFS = "CurrentPagePref";

    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private String currentPage = "page";
    private String currentKey = "key";


    public LocalData(Context context) {
        this.appSharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public int getCurrentPage() {
        return appSharedPrefs.getInt(currentPage, 1);
    }

    public void setCurrentPage(int page) {
        prefsEditor.putInt(currentPage, page);
        prefsEditor.commit();
    }

    public String getCurrentKey() {
        return appSharedPrefs.getString(currentKey, "*");
    }

    public void setCurrentKey(String key) {
        prefsEditor.putString(currentKey, key);
        prefsEditor.commit();
    }
}
