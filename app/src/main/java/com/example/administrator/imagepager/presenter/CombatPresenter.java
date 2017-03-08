package com.example.administrator.imagepager.presenter;

import android.app.Activity;
import android.os.SystemClock;
import android.widget.Toast;

import com.example.administrator.imagepager.interface_.ICombat;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class CombatPresenter {
    ICombat mICombat;
    Activity mAcivity;

    public CombatPresenter(Activity acivity, ICombat combat) {
        mAcivity = acivity;
        mICombat = combat;
    }

    public void startCombat() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                mAcivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mICombat.setKill(12);
                        mICombat.setDie(1);
                        mICombat.setAssist(23);
                    }
                });
            }
        }).start();
    }

    public void getResult() {
        String kill = mICombat.getKill();
        String die = mICombat.getDie();
        String assist = mICombat.getAssist();

        String str1 = kill.substring(kill.lastIndexOf(":") + 1, kill.length()).replaceAll(" ", "");
        String str2 = die.substring(die.lastIndexOf(":") + 1, die.length()).replaceAll(" ", "");
        String str3 = assist.substring(assist.lastIndexOf(":") + 1, assist.length()).replaceAll(" ", "");
        Toast.makeText(mAcivity, "本局战绩 : " + str1 + "/" + str2 + "/" + str3, Toast.LENGTH_SHORT).show();
    }
}

