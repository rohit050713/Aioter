package com.aioter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.R;
import com.aioter.models.DeviceItemModal;

import java.util.List;

public class DeviceItemAdapter extends RecyclerView.Adapter<DeviceItemAdapter.MyViewHolder> {

    //here we are making the list of that custom data type(remember we created it in step 4)
    private List<DeviceItemModal> listOfCustomData;

    //IMPORTANT: this a viewHolder and gives you the id of the items(child views) in your CUSTOM VIEW that you are giving
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView devicenme;
        public TextView deviceserialnumber;
        public TextView switches;

        MyViewHolder(View view) {
            super(view);
            devicenme = view.findViewById(R.id.tvDevicenme);
            deviceserialnumber = view.findViewById(R.id.tvDeviceserialnumber);
            switches = view.findViewById(R.id.tvSwitches);
        }
    }

    //custom constructor as usual for values
    public DeviceItemAdapter(List<DeviceItemModal> listOfCustomData) {
        this.listOfCustomData = listOfCustomData;
    }

    //as we are extending Recycler class therefore we have to implement 3 methods

    //METHOD 1: this will help in holding and loading the CUSTOM VIEW
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //getting the custom data of current position
        DeviceItemModal currentdata = listOfCustomData.get(position);
        //now here we can set the data to any views that we want..
        holder.devicenme.setText(currentdata.getmDeviceName());
        holder.deviceserialnumber.setText(currentdata.getmDeviceSerialNo());
        holder.switches.setText(currentdata.getmSwitchNo());
    }

    //this method simply return the size of our **list**
    @Override
    public int getItemCount() {
        return listOfCustomData.size();
    }
}