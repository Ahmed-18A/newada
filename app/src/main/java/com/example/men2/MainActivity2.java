package com.example.men2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText name = findViewById(R.id.name);
        EditText pass = findViewById(R.id.pass);
        Button log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String password = pass.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("admin") && password.equals("admin")) {
                        Toast.makeText(MainActivity2.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("name", username);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "wrong info", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
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