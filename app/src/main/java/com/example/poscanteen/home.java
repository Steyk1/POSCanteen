package com.example.poscanteen;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home extends AppCompatActivity {

    private ImageButton home;
    private Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);


        // Correctly reference the ID
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        checkout = findViewById(R.id.checkoutBtn);
        checkout.setOnClickListener(e -> {
            // Navigate from home activity to checkout activity
            Intent intent = new Intent(home.this, checkout.class);
            startActivity(intent);
        });
    }

}