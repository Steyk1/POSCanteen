package com.example.poscanteen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        AppCompatButton checkout = findViewById(R.id.checkoutBtn);
        ImageButton menuBtn = findViewById(R.id.menubtn);

        // Add the fragment to the activity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.sideMenus, new SideMenuFragment())
                    .commit();
        }



        // Checkout button listener
        checkout.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, checkout.class);
            startActivity(intent);
        });

        // Menu button click listener (toggles the fragment visibility)
        menuBtn.setOnClickListener(v -> {
            SideMenuFragment fragment = (SideMenuFragment) getSupportFragmentManager().findFragmentById(R.id.sideMenus);
            if (fragment != null) {
                fragment.toggleSideMenu();
            }
        });
    }
}
