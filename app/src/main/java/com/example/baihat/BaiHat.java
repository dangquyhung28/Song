package com.example.baihat;

import java.io.Serializable;

public class BaiHat implements Serializable {
    int Id;
    String Name;
    String Singer;
    Float Time;

    public BaiHat(int id, String name, String singer, Float time) {
        this.Id = id;
        Name = name;
        Singer = singer;
        this.Time = time;
    }
}
