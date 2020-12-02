package com.example.kursachphotogallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    private static final int REQUST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyTag", "Старт");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUST_CODE);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Gallery.ImageGalleryAdapter adapter = new Gallery.ImageGalleryAdapter(this);
        recyclerView.setAdapter(adapter);
        Log.d("MyTag", "Адаптер присоединен");


    }

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("MyTag", "onCreateViewHolder");
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the layout
            View photoView = inflater.inflate(R.layout.item_photo, parent, false);

            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {
            Log.d("MyTag", "onBindViewHolder");
            String photo = photos.get(position);
            ImageView imageView = holder.mPhotoImageView;

            Glide.with(mContext)
                    .load(photo)
                    .placeholder(R.drawable.ic_cloud_off_red)
                    .error(R.drawable.picture)
                    .into(imageView);


        }

        @Override
        public int getItemCount() {
            return (photos.size());
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    String photo = photos.get(position);

                    Intent intent = new Intent(mContext, PhotoActivity.class);
                    intent.putExtra(PhotoActivity.EXTRA_SPACE_PHOTO, photo);
                    startActivity(intent);
                }
            }
        }

        private ArrayList<String> photos;
        private Context mContext;

        public ImageGalleryAdapter(Context context) {
            mContext = context;
            photos = Photo.getImageList(context);
        }
    }
}
