package com.example.demokurssach;

import java.io.Serializable;

public class Slot implements Serializable {
    int img;
    float coast;
    int id;
    CharSequence txtView;

    public Slot(Object a, CharSequence b, float c, int i){
        img = (int) a;
        txtView = b;
        coast = c;
        id = i;
    }
}
