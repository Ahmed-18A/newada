package com.example.men2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = null;

            if (id == R.id.mnu_home) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.mnu_in) {
                intent = new Intent(this, MainActivity2.class);
            } else if (id == R.id.mnu_dash) {
                intent = new Intent(this, MainActivity3.class);
            }
            if (intent != null) {
                startActivity(intent);
                return true;
            }
            return false;
        });

    }
}