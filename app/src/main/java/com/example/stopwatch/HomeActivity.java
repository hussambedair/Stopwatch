package com.example.stopwatch;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button startNow;
    Button finishWorkout;
    ImageView anchor;

    Chronometer timer;

    Animation btgtwo;
    Animation rounding;
    Animation noRounding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startNow = findViewById(R.id.start_now_button);
        startNow.setOnClickListener(this);
        finishWorkout = findViewById(R.id.finish_workout_button);
        finishWorkout.setOnClickListener(this);
        anchor = findViewById(R.id.anchor);
        timer = findViewById(R.id.timer);

        // we want the finishWorkout button to be hidden
        finishWorkout.setAlpha(0);

        applyFont();
        applyAnimations();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.start_now_button:
                rounding = AnimationUtils.loadAnimation(this,R.anim.rounding);
                anchor.startAnimation(rounding);
                // show finishWorkout button
                finishWorkout.animate().alpha(1).translationY(-80).setDuration(300).start();
                // hide startNow button
                startNow.animate().alpha(0).setDuration(300).start();
                // start the timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

                break;

            case R.id.finish_workout_button:
                noRounding = AnimationUtils.loadAnimation(this,R.anim.norounding);
                anchor.startAnimation(noRounding);
                // show startNow button
                startNow.animate().alpha(1).setDuration(300).start();
                // hide finishWorkout button
                finishWorkout.animate().alpha(0).setDuration(300).start();
                // stop the timer
                timer.setText("00:00");
                timer.stop();


                break;
        }
    }

    public void applyFont() {
        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //apply font
        startNow.setTypeface(MMedium);
        finishWorkout.setTypeface(MMedium);
    }

    public void applyAnimations() {
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);
        startNow.startAnimation(btgtwo);
        finishWorkout.startAnimation(btgtwo);
    }
}
