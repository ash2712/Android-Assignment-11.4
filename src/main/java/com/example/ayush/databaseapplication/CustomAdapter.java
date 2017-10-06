package com.example.ayush.databaseapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 10/5/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private ArrayList<Data> list ;
    LayoutInflater mLayoutInflator;
    MainActivity context;
    public CustomAdapter(MainActivity context, ArrayList list){
        this.list = list;
        this.context = context;
        mLayoutInflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*inflates the view and sets the text for the first name and surname*/

        convertView = mLayoutInflator.inflate(R.layout.row, null);

        TextView tv_id = (TextView) convertView.findViewById(R.id.textView_id);
        TextView tv_name = (TextView) convertView.findViewById(R.id.textView_name);
        TextView tv_surname = (TextView) convertView.findViewById(R.id.textView_surname);

        tv_id.setText("ID: " + String.valueOf(list.get(position).getId()));
        tv_name.setText("First Name: " + list.get(position).getFirstName());
        tv_surname.setText("Last Name: " + list.get(position).getSurname());


        return convertView;
    }

}
