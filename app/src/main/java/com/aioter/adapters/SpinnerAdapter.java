package com.aioter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aioter.R;

public class SpinnerAdapter extends ArrayAdapter<String> {
    String [] objects;

    public SpinnerAdapter(@NonNull Context context, int resource, String [] objects) {
        super(context, resource, objects);
        this.objects=objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_device_switch,parent,false);
        final TextView label=(TextView) view.findViewById(R.id.tv_dropdown);
        label.setText(objects[position]);
        return view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(final int position, View convertview, ViewGroup parent){
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_device_switch,parent,false);
        final TextView label=(TextView) row.findViewById(R.id.spinner_tv);
        label.setText(objects[position]);
        return row;
    }
}
