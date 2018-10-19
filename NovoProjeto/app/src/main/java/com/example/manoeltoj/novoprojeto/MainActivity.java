package com.example.manoeltoj.novoprojeto;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.utils.LottieValueAnimator;

public class MainActivity extends AppCompatActivity{

    LottieAnimationView play ;
    LottieAnimationView loading;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        play = findViewById(R.id.lottiePlay);
        //loading = findViewById(R.id.lottieLoading);
        button = findViewById(R.id.button);

        //loading.playAnimation();
    }
    public void play(){
        loading.playAnimation();
    }
}
