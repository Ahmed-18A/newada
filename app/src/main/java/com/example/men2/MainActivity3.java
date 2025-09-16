package com.example.men2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {

    TextView name;
    Button ex, out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.da_name);
        ex = findViewById(R.id.exit);
        out = findViewById(R.id.log_out);
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("email", "User");
        name.setText("Welcome " + savedName);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                Toast.makeText(MainActivity3.this, "Logged out successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent2 = null;

            if (id == R.id.mnu_home) {
                intent2 = new Intent(this, MainActivity.class);
            } else if (id == R.id.mnu_in) {
                intent2 = new Intent(this, MainActivity2.class);
            } else if (id == R.id.mnu_dash) {
                intent2 = new Intent(this, MainActivity3.class);
            }

            if (intent2 != null) {
                startActivity(intent2);
                return true;
            }
            return false;
        });
    }
}
