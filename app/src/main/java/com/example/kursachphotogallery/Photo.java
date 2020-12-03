package com.example.kursachphotogallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;

import java.util.ArrayList;

public class Photo {

    public static ArrayList<String> getImageDate(Context context) {

        ArrayList<String> list_date = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.Media.DATE_ADDED);
        if (cursor.moveToLast()) {
            do {
                list_date.add(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED)));
            } while (cursor.moveToPrevious());
            cursor.close();
        }
        return list_date;
    }

    public static ArrayList<String> getImageList(Context context) {

        ArrayList<String> list_image = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.Media.DATE_ADDED);
        if (cursor.moveToLast()) {
            do {
                list_image.add(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
            } while (cursor.moveToPrevious());
            cursor.close();
        }
        return list_image;
    }

    public static ArrayList<String> getImageName(Context context) {

        ArrayList<String> list_name = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.Media.DATE_ADDED);
        if (cursor.moveToLast()) {
            do {
                list_name.add(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
            } while (cursor.moveToPrevious());
            cursor.close();
        }
        return list_name;
    }
}
