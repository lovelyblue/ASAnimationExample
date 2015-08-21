package com.asexample.kylelin.asanimationexample;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView tvNumberTitle;
    Switch swSwithc1;
    ProgressBar pbProgressBar;
    ProgressBar pbLargeProgressBar;
    ProgressBar pbHerProgressBar;
    boolean swBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumberTitle = (TextView)findViewById(R.id.tvNumberAnimation);
        swSwithc1 = (Switch)findViewById(R.id.switch1);
        swBool = true;
        pbProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        pbProgressBar.setMax(100);
        pbLargeProgressBar = (ProgressBar)findViewById(R.id.progressBar2);
        pbProgressBar.setMax(100);
        pbHerProgressBar = (ProgressBar)findViewById(R.id.progressBar3);
        pbHerProgressBar.setMax(100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnCueNumberAnimationClicked(View view)
    {
        ValueAnimator animator = ValueAnimator.ofFloat(1f,100f);
        animator.setDuration(1000);
        animator.addUpdateListener(new animationListener());
        animator.addUpdateListener(new animationListener2());
        animator.start();

        ValueAnimator animInt = ValueAnimator.ofInt(1,100);
        animInt.setDuration(1000);
        animInt.addUpdateListener(new animationListener3());
        animInt.start();
//        tvNumberTitle.setText(animator.getAnimatedValue().toString());
    }

    public class animationListener implements ValueAnimator.AnimatorUpdateListener{

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            tvNumberTitle.setText(animation.getAnimatedValue().toString());
        }
    }

    public class animationListener2 implements ValueAnimator.AnimatorUpdateListener{

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            if(animation.getAnimatedValue().toString().equalsIgnoreCase("100.0"))
            {
                swBool = !swBool;
                swSwithc1.setChecked(swBool);
            }
        }
    }
    public class animationListener3 implements ValueAnimator.AnimatorUpdateListener{

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
//            if(.toString().equalsIgnoreCase("100.0"))
            pbProgressBar.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
            pbHerProgressBar.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
        }
    }
}
