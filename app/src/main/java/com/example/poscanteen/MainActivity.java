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


        FirebaseApp.initializeApp(this);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        login = findViewById(R.id.loginBtn);
        login.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, home.class);
            startActivity(intent);
        });


        register = findViewById(R.id.regtxt);
        register.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, register.class);
            startActivity(intent);
        });
    }
}
