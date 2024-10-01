package com.example.poscanteen;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class transactionHistory extends AppCompatActivity {
    ImageButton menuBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_history);

        menuBtn = findViewById(R.id.menubtn);

        // Handle window insets to adapt for system bars
        View transactionHistory = findViewById(R.id.transactionId);
        if (transactionHistory != null) {
            ViewCompat.setOnApplyWindowInsetsListener(transactionHistory, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Add the side menu fragment to the activity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.sideMenus, new SideMenuFragment()) // Replace with the fragment container ID
                    .commit();
        }

        // Toggle the side menu when the menu button is clicked
        menuBtn.setOnClickListener(v -> {
            SideMenuFragment sideMenuFragment = (SideMenuFragment) getSupportFragmentManager().findFragmentById(R.id.sideMenus);
            if (sideMenuFragment != null) {
                sideMenuFragment.toggleSideMenu();
            }
        });

    }
}