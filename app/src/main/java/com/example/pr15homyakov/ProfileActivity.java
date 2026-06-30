package com.example.pr15homyakov;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        setupClickListeners();
        setupBottomNavigation();
    }

    private void setupClickListeners() {
        // Фото для просмотра
        int[] photoIds = {R.id.iv_photo1, R.id.iv_photo2, R.id.iv_photo3, R.id.iv_photo4};
        int[] photoRes = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4};

        for (int i = 0; i < photoIds.length; i++) {
            final int resId = photoRes[i];
            final int viewId = photoIds[i];
            findViewById(viewId).setOnClickListener(v -> {
                Intent intent = new Intent(ProfileActivity.this, PhotoDetailActivity.class);
                intent.putExtra("image_id", resId);
                startActivity(intent);
            });
        }

        // Кнопка выхода
        TextView tvExit = findViewById(R.id.tv_exit);
        tvExit.setOnClickListener(v -> {
            Toast.makeText(ProfileActivity.this, "Выход из аккаунта", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // Иконка меню
        ImageView ivMenu = findViewById(R.id.iv_menu_profile);
        ivMenu.setOnClickListener(v -> {
            Toast.makeText(ProfileActivity.this, "Меню в разработке", Toast.LENGTH_SHORT).show();
        });
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_profile);
        bottomNav.setItemIconTintList(null);
        bottomNav.setSelectedItemId(R.id.nav_profile);

        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            } else if (item.getItemId() == R.id.nav_settings) {
                Toast.makeText(this, "Настройки в разработке", Toast.LENGTH_SHORT).show();
                return true;
            }
            return true;
        });
    }
}