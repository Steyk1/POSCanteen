package com.example.poscanteen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private TextView register;
    private EditText username, password;


    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        username =findViewById(R.id.usernameInput);

        password =findViewById(R.id.passwordInput);

        // Correctly reference the ID
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.passwordInput);
        login = findViewById(R.id.loginBtn);
        register = findViewById(R.id.regtxt);

        // Login button click handler
        login.setOnClickListener(v -> {
            String email = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (validateInputs(email, pass)) {
                loginUser(email, pass);
            }
        });

        // Redirect to register page
        register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, register.class);
            startActivity(intent);
        });
    }

    // Method to validate input fields
    private boolean validateInputs(String email, String password) {
        if (email.isEmpty()) {
            username.setError("Email is required");
            return false;
        }
        if (password.isEmpty()) {
            this.password.setError("Password is required");
            return false;
        }
        return true;
    }

    // Method to log in the user using Firebase Auth
    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login successful, redirect to home screen
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, home.class); // Assuming 'home' is another activity
                        startActivity(intent);
                        finish();
                    } else {
                        // Login failed
                        Toast.makeText(MainActivity.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}