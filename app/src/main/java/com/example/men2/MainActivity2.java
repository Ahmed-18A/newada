package com.example.men2;

import android.content.Intent;
import android.content.SharedPreferences;
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
        SharedPreferences share=getSharedPreferences("UserPrefs",MODE_PRIVATE);
        EditText name = findViewById(R.id.name);
        EditText pass = findViewById(R.id.pass);
        Button sign=findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString().trim();
                String password = pass.getText().toString().trim();
                SharedPreferences.Editor edetor = share.edit();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    edetor.putString("email",username);
                    edetor.putString("pass",password);
                    edetor.apply();
                }
            }
        });
        Button log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saved_username = share.getString("email",null);
                String saved_password = share.getString("pass",null);

                String username = name.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (saved_username.equals(username)&&saved_password.equals(password)) {
                        Toast.makeText(MainActivity2.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = share.edit();
                        editor.putBoolean("isLoggedIn", true);
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("name", username);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity2.this, "sign up first", Toast.LENGTH_SHORT).show();
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