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
    }
}