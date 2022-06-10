package com.example.demokurssach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class nezuko extends AppCompatActivity implements View.OnClickListener {
    Button btnBin;
    public List<Slot> slot = new ArrayList<>();
    Intent intent;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        slot = (List<Slot>) getIntent().getSerializableExtra("list");
        setContentView(R.layout.nezuko);
        btnBin = (Button) findViewById(R.id.button2);
        btnBin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        slot.add(new Slot(R.drawable.nezuko, getText(R.string.Nezuko), 300, 5));
        intent.putExtra("list", (Serializable) slot);
        intent.putExtra("sum", 300);
        setResult(RESULT_OK, intent);
    }
}