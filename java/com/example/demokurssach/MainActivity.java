package com.example.demokurssach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ImageButton slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8;
    Button add1, add2, add3, add4, add5, add6, add7, add8, cart;
    public List<Slot> slot = new ArrayList<>();
    float summa = 0;
    private FirebaseDatabase base;
    private DatabaseReference myRef;


    /** Called when the activity is first created. */
    @SuppressLint("CutPasteId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView a = (TextView)findViewById(R.id.sum);
        a.setText((CharSequence)("Стоимость товаров в корзине: " + summa));
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

        base = FirebaseDatabase.getInstance();
        myRef = base.getReference();
        initFirebase();
    }

    private void initFirebase() {
        //инициализируем наше приложение для Firebase согласно параметрам в google-services.json
        // (google-services.json - файл, с настройками для firebase, кот. мы получили во время регистрации)
        FirebaseApp.initializeApp(this);
        //получаем точку входа для базы данных

        //получаем ссылку для работы с базой данных

    }

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
            case R.id.imageButton3:
                Intent intent = new Intent(this, ActivitySlot.class);
                startActivityForResult(intent.putExtra("list", (Serializable) slot), SECOND_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.imageButton2:
            case R.id.imageButton4:
                Intent intent5 = new Intent(this, mona.class);
                startActivityForResult(intent5.putExtra("list", (Serializable) slot), SECOND_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.imageButton5:
                Intent intent6 = new Intent(this, nezuko.class);
                startActivityForResult(intent6.putExtra("list", (Serializable) slot), SECOND_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.imageButton6:
                Intent intent7 = new Intent(this, princess.class);
                startActivityForResult(intent7.putExtra("list", (Serializable) slot), SECOND_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.imageButton7:
            case R.id.imageButton8:
                Intent intent8 = new Intent(this, zerotwo.class);
                startActivityForResult(intent8.putExtra("list", (Serializable) slot), SECOND_ACTIVITY_REQUEST_CODE);
                break;
            case R.id.add1:
            case R.id.add3:
                slot.add(new Slot(R.drawable.megumin, getText(R.string.Megumin), 500, 3));
                summa += 500;
                break;
            case R.id.add2:
            case R.id.add4:
                slot.add(new Slot(R.drawable.mona, getText(R.string.Mona), 475, 4));
                summa += 475;
                break;
            case R.id.add5:
                slot.add(new Slot(R.drawable.nezuko, getText(R.string.Nezuko), 300,5));
                summa += 300;
                break;
            case R.id.add6:
                slot.add(new Slot(R.drawable.princess, getText(R.string.princess), 600,6));
                summa += 600;
                break;
            case R.id.add7:
            case R.id.add8:
                slot.add(new Slot(R.drawable.zero2, getText(R.string.zero_two), 350,7));
                summa += 350;
                break;
            case R.id.cart:
                Intent ShopCart = new Intent(this, ActivityTwo.class);
                ShopCart.putExtra("list", (Serializable) slot);
                //ShopCart.putExtra("cost", summa);
                addblockFirebaset();
                startActivityForResult(ShopCart, SECOND_ACTIVITY_REQUEST_CODE);
                break;
            default:
                Intent def = new Intent(this, ActivitySlot.class);
                startActivity(def);
                break;
        }
        TextView a = (TextView)findViewById(R.id.sum);
        a.setText((CharSequence)("Стоимость товаров в корзине: " + summa));
    }

    private void addblockFirebaset() {
        for(Slot items : slot) {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(20);
            for (int i = 0; i < 20; i++) {

                // generate a random number between
                // 0 to AlphaNumericString variable length

                int index  = (int) (AlphaNumericString.length()* Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }

            myRef.child(sb.toString())
                    .child("id")
                    .setValue(items.getId());
            myRef.child(sb.toString())
                    .child("name")
                    .setValue(items.getTxtView());
            myRef.child(sb.toString())
                    .child("cost")
                    .setValue(items.getCoast());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                slot = (List<Slot>) data.getSerializableExtra("list");
            }
        }
    }
}