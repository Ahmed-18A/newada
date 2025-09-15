package com.example.men2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView name=findViewById(R.id.da_name);
        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        name.setText("welcome"+n);
        Button ex=findViewById(R.id.exit);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        Button out=findViewById(R.id.log_out);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("welcome user");
                Toast.makeText(MainActivity3.this, "logged out successfully", Toast.LENGTH_SHORT).show();
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