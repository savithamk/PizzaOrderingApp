package com.savithamaiya.pizzaapplication;

import static com.savithamaiya.pizzaapplication.R.layout.activity_splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SpleshActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(activity_splash_screen);
        nextScreen();
    }
    private void nextScreen() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SpleshActivity.this,MainActivity.class));
            finish();
        }, 3000);
    }
}
