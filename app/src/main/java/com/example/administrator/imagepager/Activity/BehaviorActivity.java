package com.example.administrator.imagepager.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.imagepager.R;

//import android.support.v7.widget.Toolbar;

public class BehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        init();
    }

    private void init() {
        View view = findViewById(R.id.tb);
        try {
            String clazzName = view.getClass().getName().toString();
            if (clazzName.equals("android.widget.Toolbar")) {
                android.widget.Toolbar tb = (android.widget.Toolbar) view;
                setActionBar(tb);
            } else if (clazzName.equals("android.support.v7.widget.Toolbar")) {
                android.support.v7.widget.Toolbar tb = (android.support.v7.widget.Toolbar) view;
                setSupportActionBar(tb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
