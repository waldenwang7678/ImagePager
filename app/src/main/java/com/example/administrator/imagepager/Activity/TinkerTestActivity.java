package com.example.administrator.imagepager.Activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.imagepager.R;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class TinkerTestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinker_test);
        initView();
    }

    private void initView() {
        findViewById(R.id.tinker_bt1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tinker_bt1:
                TinkerInstaller.onReceiveUpgradePatch(
                        this.getApplication(), Environment.getExternalStorageDirectory().getAbsolutePath()+"/a1");
                Toast.makeText(this, "阿萨德 , 对的 !!!!! ~", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
