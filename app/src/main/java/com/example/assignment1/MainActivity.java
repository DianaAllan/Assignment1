package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private TextView txt;
    private Animation top ,bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txt=findViewById(R.id.AppName);
        img=findViewById(R.id.imageView2);

        txt.setAnimation(bottom);
        img.setAnimation(top);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);

    }
}