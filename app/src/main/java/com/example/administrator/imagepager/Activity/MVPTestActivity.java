package com.example.administrator.imagepager.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.imagepager.R;
import com.example.administrator.imagepager.interface_.ICombat;
import com.example.administrator.imagepager.presenter.CombatPresenter;

public class MVPTestActivity extends AppCompatActivity implements View.OnClickListener, ICombat {

    private TextView mKill;
    private TextView mDie;

    private TextView mAassist;
    CombatPresenter combatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvptest);
        initView();
        initEvent();
    }

    private void initView() {
        mKill = (TextView) findViewById(R.id.kill);
        mDie = (TextView) findViewById(R.id.die);
        mAassist = (TextView) findViewById(R.id.assist);
        findViewById(R.id.bt_m).setOnClickListener(this);
        findViewById(R.id.bt_getresult).setOnClickListener(this);
    }

    private void initEvent() {
        combatPresenter = new CombatPresenter(this, this);
    }

    @Override
    public void setKill(int kill) {
        mKill.setText("kill : " + kill);
    }

    @Override
    public void setDie(int die) {
        mDie.setText("die : " + die);
    }

    @Override
    public void setAssist(int assist) {
        mAassist.setText("assist : " + assist);
    }

    @Override
    public String getKill() {
        return mKill.getText().toString();
    }

    @Override
    public String getDie() {
        return mDie.getText().toString();
    }

    @Override
    public String getAssist() {
        return mAassist.getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_m:
                combatPresenter.startCombat();   //设置数据
                break;
            case R.id.bt_getresult:
                combatPresenter.getResult();
                break;
        }
    }
}
