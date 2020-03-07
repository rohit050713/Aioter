package com.aioter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.R;
import com.aioter.models.RunningStateDeviceItemModal;

import java.util.List;

public class UnreachableDeviceAdapter extends RecyclerView.Adapter<UnreachableDeviceAdapter.MyViewHolder> {

    private List<RunningStateDeviceItemModal> listOfCustomData;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.itemtyperunning);
            imageView = view.findViewById(R.id.itemrunning);
        }
    }


    public UnreachableDeviceAdapter(List<RunningStateDeviceItemModal> listOfCustomData) {
        this.listOfCustomData = listOfCustomData;
    }


    @NonNull
    @Override
    public UnreachableDeviceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unreachable_device_item, parent, false);
        return new UnreachableDeviceAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnreachableDeviceAdapter.MyViewHolder holder, int position) {
        RunningStateDeviceItemModal currentdata = listOfCustomData.get(position);
        //now here we can set the data to any views that we want..
        holder.textView.setText(currentdata.getmDeviceName());
        holder.imageView.setImageResource(currentdata.getmDeviceIcon());


    }

    @Override
    public int getItemCount() {
        return listOfCustomData.size();
    }
}