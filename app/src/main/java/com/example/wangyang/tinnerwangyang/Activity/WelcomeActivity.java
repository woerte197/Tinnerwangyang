package com.example.wangyang.tinnerwangyang.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends BaseActivity {
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(binding.welcomeImage, "alpha", 0.1f, 1.0f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
