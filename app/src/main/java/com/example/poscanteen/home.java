package com.example.poscanteen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class home extends AppCompatActivity {

    private boolean isMenuVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        LinearLayout sideMenu = findViewById(R.id.sideMenu);
        RelativeLayout sideMenus = findViewById(R.id.sideMenus);
        ImageButton homeBtn = findViewById(R.id.homeBtn);
        ImageButton sideBtn = findViewById(R.id.sideBtn);
        AppCompatButton checkout = findViewById(R.id.checkoutBtn);


        // Home Button OnClickListener
        homeBtn.setOnClickListener(v -> {
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

        // Checkout Button OnClickListener
        checkout.setOnClickListener(e -> {
            Intent intent = new Intent(home.this, checkout.class);
            startActivity(intent);
        });
    }
}
