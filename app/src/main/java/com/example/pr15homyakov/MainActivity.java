package com.example.pr15homyakov;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lastSelectedLayout = null;
    private int defaultCircleColor, selectedCircleColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defaultCircleColor = ContextCompat.getColor(this, R.color.white);
        selectedCircleColor = ContextCompat.getColor(this, R.color.teal_200);

        setupFeelingButton(R.id.ll_calm, "Спокойный");
        setupFeelingButton(R.id.ll_relax, "Расслабленный");
        setupFeelingButton(R.id.ll_focus, "Сосредоточенный");
        setupFeelingButton(R.id.ll_anxious, "Взволнованный");

        ImageView ivProfile = findViewById(R.id.iv_profile);
        ivProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        ImageView ivMenu = findViewById(R.id.iv_menu);
        ivMenu.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Меню в разработке", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.card_quote).setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Вдохновляющая цитата дня", Toast.LENGTH_LONG).show();
        });

        findViewById(R.id.btn_card_action).setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Начать медитацию", Toast.LENGTH_SHORT).show();
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setItemIconTintList(null);
        bottomNav.setSelectedItemId(R.id.nav_home);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            } else if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_settings) {
                Toast.makeText(this, "Настройки в разработке", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }

    private void setupFeelingButton(int layoutId, String feeling) {
        LinearLayout layout = findViewById(layoutId);
        layout.setOnClickListener(v -> {
            if (lastSelectedLayout != null) {
                resetFeelingStyle(lastSelectedLayout);
            }

            selectFeelingStyle(layout);
            lastSelectedLayout = layout;

            Toast.makeText(this, "Вы выбрали: " + feeling, Toast.LENGTH_SHORT).show();
        });
    }

    private void selectFeelingStyle(LinearLayout layout) {
        android.view.View circle = layout.getChildAt(0);
        circle.setBackgroundTintList(ColorStateList.valueOf(selectedCircleColor));
    }

    private void resetFeelingStyle(LinearLayout layout) {
        android.view.View circle = layout.getChildAt(0);
        circle.setBackgroundTintList(ColorStateList.valueOf(defaultCircleColor));
    }
}