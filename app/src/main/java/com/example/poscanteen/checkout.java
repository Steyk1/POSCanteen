package com.example.poscanteen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class checkout extends AppCompatActivity {
    private boolean isMenuVisible = false;
AppCompatButton Additionalbtn;
AppCompatButton Paybtn;
ImageButton Menubtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.checkout);
        Additionalbtn = findViewById(R.id.additionalbtn);
        Paybtn = findViewById(R.id.paybtn);
        Menubtn = findViewById(R.id.menubtn);


// Correctly reference the ID
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.checkout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        Additionalbtn.setOnClickListener(e -> {
            Intent intent = new Intent(checkout.this, home.class);
            startActivity(intent);

        });

        Paybtn.setOnClickListener(e -> {
        Intent intent = new Intent(checkout.this, transaction.class);
        startActivity(intent);

    });
        LinearLayout sideMenu = findViewById(R.id.sideMenu);
        RelativeLayout sideMenus = findViewById(R.id.sideMenus);

        ImageButton sideBtn = findViewById(R.id.sideBtn);



        // Home Button OnClickListener
        Menubtn.setOnClickListener(v -> {
            if (!isMenuVisible) {
                // Slide in the menu
                sideMenus.setVisibility(View.VISIBLE);
                Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.menu_slide_in);
                sideMenu.startAnimation(slideIn);
                sideMenu.setVisibility(View.VISIBLE);
                isMenuVisible = true;
            } else {
                // Slide out the menu
                Animation slideOut = AnimationUtils.loadAnimation(this, R.anim.menu_slide_out);
                sideMenu.startAnimation(slideOut);
                slideOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        sideMenus.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
                isMenuVisible = false;
            }
        });

        // Side Button OnClickListener
        sideBtn.setOnClickListener(v -> {
            if (!isMenuVisible) {
                // Slide in the menu
                sideMenus.setVisibility(View.VISIBLE);
                Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.menu_slide_in);
                sideMenu.startAnimation(slideIn);
                sideMenu.setVisibility(View.VISIBLE);
                isMenuVisible = true;
            } else {
                // Slide out the menu
                Animation slideOut = AnimationUtils.loadAnimation(this, R.anim.menu_slide_out);
                sideMenu.startAnimation(slideOut);
                slideOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        sideMenus.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
                isMenuVisible = false;
            }
        });


    }

}