package com.example.poscanteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        // Enable Edge to Edge display
        EdgeToEdge.enable(this);

        // Set the content view to the main layout
        setContentView(R.layout.activity_main);

        // Apply window insets for padding to avoid overlapping system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Reference login button and set click listener
        login = findViewById(R.id.loginBtn);
        login.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        // Reference register text view and set click listener
        register = findViewById(R.id.regtxt);
        register.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
