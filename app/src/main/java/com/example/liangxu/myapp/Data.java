package com.example.liangxu.myapp;

import java.util.ArrayList;

/**
 * Created by liangxu on 2017/11/22.
 */

public class Data {
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkList=" + checkList +
                '}';
    }

    public ArrayList<String> checkList = new ArrayList<>();
}
