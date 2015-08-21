package com.asexample.kylelin.asanimationexample;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TimeAnimatorActivity extends ActionBarActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_animator);
        textView = (TextView)findViewById(R.id.tvTimeAnimator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time_animator, menu);
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

    TimeAnimator timeAnimator;
    public void btnTimeAnimatorStartClicked(View view)
    {
        timeAnimator = new TimeAnimator();
        timeAnimator.setTimeListener(new TimeAnimatorCustomeClass());
        timeAnimator.setCurrentPlayTime(10000);
        timeAnimator.start();


    }

    public void btnTimeAnimatorPauseClicked(View view)
    {
        if (timeAnimator != null)
        { timeAnimator.pause(); }
    }

    public void btnTimeAnimatorResumeClicked(View view)
    {
        if (timeAnimator != null)
        { timeAnimator.resume(); }
    }

    public class TimeAnimatorCustomeClass implements TimeAnimator.TimeListener{

        @Override
        public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
            textView.setText(totalTime+"--"+deltaTime);
        }
    }

    public void btnBackToListClicked(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this,TopLevelActivity.class);
        startActivity(intent);
    }
}
