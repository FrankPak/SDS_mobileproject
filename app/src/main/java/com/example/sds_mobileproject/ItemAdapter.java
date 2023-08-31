package com.example.sds_mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] items;
    String[] description;
    String[] calories;

    public ItemAdapter(Context c,String[] i, String[] d,String[] k){
        items = i;
        description = d;
        calories = k;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView DescriptionTextView = (TextView) v.findViewById(R.id.DescriptionTextView);
        TextView calorieTextView = (TextView) v.findViewById(R.id.calorieTextView);

        String name = items[position];
        String desc = description[position];
        String kcal = calories[position];

        nameTextView.setText(name);
        DescriptionTextView.setText(desc);
        calorieTextView.setText(kcal);


        return v;
    }
}
