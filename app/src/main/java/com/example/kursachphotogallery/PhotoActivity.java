package com.example.kursachphotogallery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PhotoActivity extends AppCompatActivity {

    public static final String EXTRA_PHOTO = "SpacePhotoActivity.SPACE_PHOTO";
    public static final String EXTRA_NAME = "SpacePhotoActivity.SPACE_NAME";

    private ImageView mImageView;
    private TextView mTextName;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        mImageView = (ImageView) findViewById(R.id.image2);
        mTextName = (TextView) findViewById(R.id.textName);



        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        String name = getIntent().getStringExtra(EXTRA_NAME);


        // Добавление картинки
        Glide.with(this)
                .load(photo)
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);


        mTextName.setText("Название: "+name);
    }



}
