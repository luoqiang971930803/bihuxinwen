package com.bihu.xinwen.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bihu.xinwen.R;

/**
 * Created by luo on 2016/9/2.
 */
public class SplashActivity extends Activity {
   private ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spash_activity);
       imageView = (ImageView) findViewById(R.id.im_view);
        AlphaAnimation alp=new AlphaAnimation(0.0f,1.0f);
        alp.setDuration(4000);
        imageView.startAnimation(alp);
        alp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               Intent intent=new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
