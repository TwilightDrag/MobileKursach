package com.example.demokurssach;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ActivityTwo extends ListActivity {
    // набор данных, которые свяжем со списком
    ArrayAdapter<Slot> adapter;
    public List<Slot> slot = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        slot = (List<Slot>) getIntent().getSerializableExtra("list");
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void delete(Slot item){
        slot.remove(item);
        adapter.notifyDataSetChanged();
        Intent intent = getIntent();
        intent.putExtra("list", (Serializable) slot);
        setResult(RESULT_OK, intent);
        }


    private class SlotAdapter extends ArrayAdapter<Slot> {

        public SlotAdapter(Context context) {
            super(context, R.layout.activity_slot, slot);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Slot slot = getItem(position);
            final ViewHolder viewHolder;

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.activity_slot, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }


            ((ImageButton) convertView.findViewById(R.id.img)).setImageResource((int) getItemId(slot.img));
            ((TextView) convertView.findViewById(R.id.empty)).setText((CharSequence) slot.txtView);
            ((TextView) convertView.findViewById(R.id.textView2)).setText((CharSequence) ("Coast: " + slot.coast));
            ((TextView) convertView.findViewById(R.id.id)).setText((CharSequence) ("id: " + slot.id));
            viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delete(slot);
                }
            });
            return convertView;
        }
    }

    private class ViewHolder {
        final Button addButton;
        ViewHolder(View view){
            addButton = view.findViewById(R.id.delete);
        }
    }
}