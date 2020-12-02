package com.example.kursachphotogallery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class PhotoActivity extends AppCompatActivity {

    public static final String EXTRA_SPACE_PHOTO = "SpacePhotoActivity.SPACE_PHOTO";

    private ImageView mImageView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        mImageView = (ImageView) findViewById(R.id.image2);
        Photo Photo = getIntent().getParcelableExtra(EXTRA_SPACE_PHOTO);

        assert Photo != null;
        Glide.with(this)
                .load(Photo.getUrl())
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);

    }



}
