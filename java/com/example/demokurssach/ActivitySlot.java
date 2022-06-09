package com.example.demokurssach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ActivitySlot extends AppCompatActivity implements View.OnClickListener {
    Button btnBin;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        btnBin = (Button) findViewById(R.id.button2);
        btnBin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
