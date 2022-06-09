package com.example.demokurssach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ImageButton slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8;
    Button add1, add2, add3, add4, add5, add6, add7, add8, cart;
    public List<Slot> slot = new ArrayList<>();



    /** Called when the activity is first created. */
    @SuppressLint("CutPasteId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slot1 = (ImageButton) findViewById(R.id.imageButton);
        slot1.setOnClickListener(this);
        slot2 = (ImageButton) findViewById(R.id.imageButton2);
        slot2.setOnClickListener(this);
        slot3 = (ImageButton) findViewById(R.id.imageButton3);
        slot3.setOnClickListener(this);
        slot4 = (ImageButton) findViewById(R.id.imageButton4);
        slot4.setOnClickListener(this);
        slot5 = (ImageButton) findViewById(R.id.imageButton5);
        slot5.setOnClickListener(this);
        slot6 = (ImageButton) findViewById(R.id.imageButton6);
        slot6.setOnClickListener(this);
        slot7 = (ImageButton) findViewById(R.id.imageButton7);
        slot7.setOnClickListener(this);
        slot8 = (ImageButton) findViewById(R.id.imageButton8);
        slot8.setOnClickListener(this);
        add1 = (Button) findViewById(R.id.add1);
        add1.setOnClickListener(this);
        add2 = (Button) findViewById(R.id.add2);
        add2.setOnClickListener(this);
        add3 = (Button) findViewById(R.id.add3);
        add3.setOnClickListener(this);
        add4 = (Button) findViewById(R.id.add4);
        add4.setOnClickListener(this);
        add5 = (Button) findViewById(R.id.add5);
        add5.setOnClickListener(this);
        add6 = (Button) findViewById(R.id.add6);
        add6.setOnClickListener(this);
        add7 = (Button) findViewById(R.id.add7);
        add7.setOnClickListener(this);
        add8 = (Button) findViewById(R.id.add8);
        add8.setOnClickListener(this);
        cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                Intent intent = new Intent(this, ActivitySlot.class);
                startActivity(intent);
                break;
            case R.id.cart:
                Intent ShopCart = new Intent(this, ActivityTwo.class);
                ShopCart.putExtra("list", (Serializable) slot);
                startActivity(ShopCart);
                break;
            case R.id.imageButton2:
                Intent intent3 = new Intent(this, ActivitySlot.class);
                startActivity(intent3);
            case R.id.imageButton3:
                Intent intent4 = new Intent(this, ActivitySlot.class);
                startActivity(intent4);
            case R.id.imageButton4:
                Intent intent5 = new Intent(this, ActivitySlot.class);
                startActivity(intent5);
            case R.id.imageButton5:
                Intent intent6 = new Intent(this, ActivitySlot.class);
                startActivity(intent6);
            case R.id.imageButton6:
                Intent intent7 = new Intent(this, ActivitySlot.class);
                startActivity(intent7);
            case R.id.imageButton7:
                Intent intent8 = new Intent(this, ActivitySlot.class);
                startActivity(intent8);
                break;
            case R.id.add1:
                slot.add(new Slot(R.drawable.megumin, getText(R.string.Megumin), 500, 1));
                break;
            case R.id.add2:

                break;
            case R.id.add3:
                slot.add(new Slot(R.drawable.megumin, getText(R.string.Megumin), 500, 3));
                break;
            case R.id.add4:
                slot.add(new Slot(R.drawable.mona, getText(R.string.Mona), 475, 4));
                break;
            case R.id.add5:
                slot.add(new Slot(R.drawable.nezuko, getText(R.string.Nezuko), 300,5));
                break;
            case R.id.add6:
                slot.add(new Slot(R.drawable.princess, getText(R.string.princess), 600,6));
                break;
            case R.id.add7:
                slot.add(new Slot(R.drawable.zero2, getText(R.string.zero_two), 350,7));
                break;
            case R.id.add8:

                break;
            default:
                Intent def = new Intent(this, ActivitySlot.class);
                startActivity(def);
                break;
        }
    }
}