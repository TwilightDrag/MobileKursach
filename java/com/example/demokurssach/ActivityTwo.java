package com.example.demokurssach;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class ActivityTwo extends ListActivity {
    // набор данных, которые свяжем со списком
    ArrayAdapter<Slot> adapter;
    Button delete;

    public List<Slot> slot = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getIntent().getExtras();

        slot = (List<Slot>) getIntent().getSerializableExtra("list");

//        delete = (Button) findViewById(R.id.delete);
//        delete.setOnClickListener(this);

        adapter = new SlotAdapter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setListAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    private class SlotAdapter extends ArrayAdapter<Slot> {

        public SlotAdapter(Context context) {
            super(context, R.layout.activity_slot, slot);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Slot slot = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.activity_slot, null);
            }


            ((ImageButton) convertView.findViewById(R.id.img)).setImageResource((int) getItemId(slot.img));
            ((TextView) convertView.findViewById(R.id.empty)).setText((CharSequence) slot.txtView);
            ((TextView) convertView.findViewById(R.id.textView2)).setText((CharSequence) ("Coast: " + slot.coast));
            ((TextView) convertView.findViewById(R.id.id)).setText((CharSequence) ("id: " + slot.id));
            ((Button) convertView.findViewById(R.id.delete)).setId(slot.id);
            return convertView;
        }
    }

}