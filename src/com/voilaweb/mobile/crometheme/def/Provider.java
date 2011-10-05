package com.voilaweb.mobile.crometheme.def;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class Provider extends ContentProvider {
    public static final Uri CONTENT_URI =
            Uri.parse("content://com.voilaweb.mobile.crometheme");
    public static final String AUTHORITY = "com.voilaweb.mobile.crometheme";

    private static final int THEMES = 0x01;
    public static final String CONTENT_TYPE_THEMES = AUTHORITY + "/theme";

    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
		matcher.addURI(AUTHORITY, "themes", THEMES);
	}

    protected MatrixCursor mCursor;

    @Override
    public boolean onCreate() {
        CLog.log("Launching PROVIDER");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        CLog.log("a query!!!");
        switch(matcher.match(uri)) {
            case THEMES:
                CLog.log("...for themes!!!!");
                mCursor = new MatrixCursor(new String[] {"_id", "name"});
                mCursor.addRow(new Object[] {0, "Default"});
                break;
            default:
                throw new IllegalArgumentException("Unknown or Invalid URI " + uri);
        }
        return mCursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (matcher.match(uri)) {
            case THEMES:
                return CONTENT_TYPE_THEMES;
            default:
                throw new IllegalArgumentException("Unknown or Invalid URI " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        throw new UnsupportedOperationException();
    }
}
