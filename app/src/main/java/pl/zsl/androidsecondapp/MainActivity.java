package pl.zsl.androidsecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ObjectAnimator animator;
    Spinner spinner;
    Button animationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner = findViewById(R.id.mainSpinner);
        animationBtn = findViewById(R.id.mainRunAnimation);
        animationBtn.setOnClickListener(e -> {
            float start = spinner.getY();
            animator = ObjectAnimator.ofFloat(spinner,"Y", start, 0, start);
            animator.setDuration(1000);
            animator.setInterpolator(new AccelerateInterpolator());
            animator.start();
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ObjectAnimator animator = ObjectAnimator.ofFloat(spinner,"rotation", 0, 360);
                    animator.setDuration(400);
                    animator.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

        });
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            float end = spinner.getY();
            animator = ObjectAnimator.ofFloat(spinner,"Y", 0, end);
            animator.setDuration(600);
            animator.setInterpolator(new AccelerateInterpolator());
            animator.start();
        },50);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}