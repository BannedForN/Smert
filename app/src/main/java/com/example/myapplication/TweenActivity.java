package com.example.myapplication;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TweenActivity extends AppCompatActivity {

    private ImageView penbAnim;
    private Button Start_but, Stop_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tween_anim);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        penbAnim = findViewById(R.id.blink_anim);
        Start_but = findViewById(R.id.start_but);
        Stop_but = findViewById(R.id.stop_but);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);
        Animation but1Anim = AnimationUtils.loadAnimation(this, R.anim.but1_anim);
        Animation but2Anim = AnimationUtils.loadAnimation(this, R.anim.but2_anim);
        Animation tweenAnim = AnimationUtils.loadAnimation(this, R.anim.tween_anim);

        but1Anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Start_but.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        but2Anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Stop_but.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        tweenAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                penbAnim.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Start_but.startAnimation(but1Anim);
        Stop_but.startAnimation(but2Anim);
        penbAnim.startAnimation(tweenAnim);

        Start_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                { penbAnim.startAnimation(blinkAnimation); }
            }
        });

        Stop_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                { penbAnim.clearAnimation(); }
            }
        });

    }
}