package com.example.pr15homyakov;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        if (getSupportActionBar() != null) getSupportActionBar().hide();

        ImageView ivFullPhoto = findViewById(R.id.iv_full_photo);

        int imageResId = getIntent().getIntExtra("image_id", 0);
        if (imageResId != 0) {
            ivFullPhoto.setImageResource(imageResId);
        } else {
            ivFullPhoto.setImageResource(R.drawable.logo);
        }

        findViewById(R.id.tv_close_photo).setOnClickListener(v -> finish());
    }
}