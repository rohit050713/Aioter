package com.aioter.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.R;
import com.aioter.activity.DeviceHomeActivity;
import com.aioter.activity.DeviceSwitchDetailActivity;
import com.aioter.models.RunningStateDeviceItemModal;

import java.util.List;

public class SwitchOnDeviceAdapter extends RecyclerView.Adapter<SwitchOnDeviceAdapter.MyViewHolder> {

    private List<RunningStateDeviceItemModal> listOfCustomData;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;

        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.itemtyperunning);
            imageView = view.findViewById(R.id.itemrunning);
            linearLayout=view.findViewById(R.id.linearlayout_item);

        }
    }


    public SwitchOnDeviceAdapter(List<RunningStateDeviceItemModal> listOfCustomData) {
        this.listOfCustomData = listOfCustomData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.switch_on_device_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RunningStateDeviceItemModal currentdata = listOfCustomData.get(position);
        //now here we can set the data to any views that we want..
        holder.textView.setText(currentdata.getmDeviceName());
        holder.imageView.setImageResource(currentdata.getmDeviceIcon());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),DeviceSwitchDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return listOfCustomData.size();
    }
}