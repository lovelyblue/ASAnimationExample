package com.asexample.kylelin.asanimationexample;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TopLevelActivity extends ActionBarActivity {

    ListView listView;
    EditText editText;
//    Object obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
//        AnimatorItemClicked animatorItemClicked = new AnimatorItemClicked();
        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(new AnimatorItemClicked(this));

        editText = (EditText)findViewById(R.id.editText);
//        obj = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top_level, menu);
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

    public void lvAnimatorClicked(View view)
    {

    }

    public class AnimatorItemClicked implements AdapterView.OnItemClickListener{
        public Context context;
        AnimatorItemClicked(Context iniContext)
        {
            context = iniContext;
        }
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0)
            {
                Intent intent = new Intent();
                intent.setClass(TopLevelActivity.this,MainActivity.class);
                startActivity(intent);
            }else if (position == 1)
            {
                Intent intent = new Intent();
                intent.setClass(parent.getContext(),TimeAnimatorActivity.class);//(TopLevelActivity.this)
                startActivity(intent);
            }
            Toast.makeText(context,"按下了Index:"+position,Toast.LENGTH_SHORT).show();
            editText.setText(parent.getItemAtPosition(position).toString());
        }
    }
}
