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

public class FrameActivity extends AppCompatActivity {

    private ImageView Frame_anim;
    private Button Start_but, Stop_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Frame_anim = findViewById(R.id.frame_anim);
        Start_but = findViewById(R.id.start_but);
        Stop_but = findViewById(R.id.stop_but);

        AnimationDrawable frameAnimation = (AnimationDrawable) Frame_anim.getDrawable();
        Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.frameac_anim);

        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Frame_anim.setVisibility(View.VISIBLE);
                Start_but.setVisibility(View.VISIBLE);
                Stop_but.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Frame_anim.startAnimation(scaleAnim);
        Start_but.startAnimation(scaleAnim);
        Stop_but.startAnimation(scaleAnim);

        Start_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                { frameAnimation.start(); }
            }
        });

        Stop_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                { frameAnimation.stop(); }
            }
        });

    }
}