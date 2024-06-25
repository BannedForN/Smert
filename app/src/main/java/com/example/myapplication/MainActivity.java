package com.example.myapplication;


import android.content.Intent;
import android.icu.util.Freezable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button Frame_but, Tween_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Frame_but = findViewById(R.id.frame_but);
        Tween_but = findViewById(R.id.tween_but);

        Animation mainbutAnim = AnimationUtils.loadAnimation(this, R.anim.mainbut_anim);

        mainbutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Frame_but.setVisibility(View.INVISIBLE);
                Tween_but.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Frame_but.setVisibility(View.VISIBLE);
                Tween_but.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Frame_but.startAnimation(mainbutAnim);
        Tween_but.startAnimation(mainbutAnim);

        Frame_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrameActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trin_anim, R.anim.trout_anim);
            }
        });

        Tween_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TweenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidein_anim, R.anim.slideout_anim);
            }
        });
    }
}