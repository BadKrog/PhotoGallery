package com.example.kursachphotogallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;

import java.util.ArrayList;

public class Photo implements Parcelable{

    private String mUrl;


    public Photo(String url) {
        mUrl = url;
    }

    protected Photo(Parcel in) {
        mUrl = in.readString();
    }

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public static  Photo[] getSpacePhotos() {

        return new Photo[]{
                new Photo("https://i.imgur.com/zuG2bGQ.jpg"),
                new Photo("https://i.imgur.com/ovr0NAF.jpg"),
                new Photo("https://i.imgur.com/n6RfJX2.jpg"),
                new Photo("https://i.imgur.com/qpr5LR2.jpg"),
                new Photo("https://i.imgur.com/pSHXfu5.jpg"),
                new Photo("https://i.imgur.com/3wQcZeY.jpg"),
                new Photo("https://i.imgur.com/3wQcZeY.jpg"),
                new Photo("https://i.imgur.com/3wQcZeY.jpg"),
                new Photo("https://i.imgur.com/3wQcZeY.jpg"),
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
    }

    public ArrayList<String> getImageList(Context my) {

        ArrayList<String> list_image = new ArrayList<>();
        ContentResolver contentResolver = my.getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.Media.DATE_ADDED);
        if (cursor.moveToLast()) {
            do {
                list_image.add(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
            } while (cursor.moveToPrevious());
            cursor.close();
        }
        return list_image;
    }
}
