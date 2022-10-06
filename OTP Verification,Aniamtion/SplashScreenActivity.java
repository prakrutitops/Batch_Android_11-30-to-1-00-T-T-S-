package com.example.animationex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    ImageView imageView,imageView2;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        button = findViewById(R.id.btn1);
        imageView = findViewById(R.id.img);
        imageView2 = findViewById(R.id.img2);

        animationDrawable = (AnimationDrawable) (imageView.getBackground());
        animatedata();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(animationDrawable.isRunning())
                {
                    animationDrawable.stop();
                }
                else
                {
                    animationDrawable.start();
                }

            }
        });

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },5000);*/
    }

    private void animatedata()
    {
        Animation animation = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.rotate);
        imageView2.startAnimation(animation);

    }
}