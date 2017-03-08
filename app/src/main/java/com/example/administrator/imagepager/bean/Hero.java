package com.example.administrator.imagepager.bean;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class Hero {
    String name;
    String skill;

    public Hero(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
