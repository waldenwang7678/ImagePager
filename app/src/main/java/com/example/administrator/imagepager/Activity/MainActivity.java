package com.example.administrator.imagepager.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.imagepager.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        findViewById(R.id.pager).setOnClickListener(this);
        findViewById(R.id.que).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
        findViewById(R.id.bt7).setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pager:
                j(PagerActivity.class);
                break;
            case R.id.que:
                j(DefeViewActivity.class);
                break;
            case R.id.bt3:
                j(MVPTestActivity.class);
                break;
            case R.id.bt4:
                j(MVVPActivity.class);
                break;
            case R.id.bt5:
                j(ThreadTestActivity.class);
                break;
            case R.id.bt6:
                j(ViewDragActivity.class);
                break;
            case R.id.bt7:
                j(BehaviorActivity.class);
                break;
            case R.id.bt8:
                j(TinkerTestActivity.class);
                break;
        }
    }

    private void j(Class c) {
        Intent i = new Intent(this, c);
        startActivity(i);
    }
}
