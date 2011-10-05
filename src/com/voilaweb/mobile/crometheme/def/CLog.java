package com.voilaweb.mobile.crometheme.def;

public class CLog {
    static protected String TAG = "CromeThemeDef";

    static public void log(String txt) {
        android.util.Log.d(TAG, TAG + ": " + txt);
    }

    static public void log(String txt, Exception ex) {
        android.util.Log.d(TAG, TAG + ": " + txt, ex);
    }

    static public void error(String txt) {
        android.util.Log.e(TAG, TAG + ": " + txt);
    }

    static public void error(String txt, Exception ex) {
        android.util.Log.e(TAG, TAG + ": " + txt, ex);
    }
}
