package com.example.administrator.imagepager.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.imagepager.R;
import com.example.administrator.imagepager.bean.Hero;
import com.example.administrator.imagepager.bean.User;
import com.example.administrator.imagepager.databinding.ActivityMvvpBinding;

public class MVVPActivity extends AppCompatActivity {

    private TextView mvvp_tv1;
    private TextView mvvp_tv2;
    private ActivityMvvpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvp);
        initviw();
        initData();

    }

    private void initviw() {
        mvvp_tv1 = (TextView) findViewById(R.id.mvvp_tv1);
        mvvp_tv2 = (TextView) findViewById(R.id.mvvp_tv2);
    }

    private void initData() {
        Hero hero = new Hero("光之守卫", "Chakra魔法");
        User user = new User("风暴之灵", 12, "man");
        binding.setHero(hero);
        binding.setUser(user);
    }
}
