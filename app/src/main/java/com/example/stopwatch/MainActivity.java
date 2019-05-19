package com.example.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text1, text2;
    Button start;
    ImageView splashImage;
    Animation atg;
    Animation btgone;
    Animation btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start =findViewById(R.id.get_started_button);
        start.setOnClickListener(this);
        text1 =findViewById(R.id.healthy_text);
        text2 = findViewById(R.id.quote_text);
        splashImage = findViewById(R.id.splash_image);

        applyAnimations();
        applyFont();




    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.get_started_button:
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
        }
    }

    public void applyFont() {
        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //apply font
        text1.setTypeface(MRegular);
        text2.setTypeface(MLight);
        start.setTypeface(MMedium);
    }

    public void applyAnimations() {
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);
        //pass the animation to the image
        splashImage.startAnimation(atg);

        //pass the animation to the textviews and button
        text1.startAnimation(btgone);
        text2.startAnimation(btgtwo);
        start.startAnimation(btgtwo);
    }
}
