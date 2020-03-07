package com.aioter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.MainModel;
import com.aioter.R;
import com.aioter.listener.DeviceInterface;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<MainModel> mainModels;
    Context context;
    DeviceInterface deviceInterface;
    public RecyclerAdapter(Context context, ArrayList<MainModel> mainModels, DeviceInterface deviceInterface) {
        this.context = context;
        this.mainModels = mainModels;
        this.deviceInterface = deviceInterface;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.device_list, parent,false);
        ViewHolder vholder =new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imglogo.setImageResource(mainModels.get(position).getLanglogo());
        holder.txtduo.setText(mainModels.get(position).getLangDuo());
        holder.txtroom.setText(mainModels.get(position).getLangRoom());

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imglogo;
        TextView txtduo, txtroom;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imglogo = (ImageView) itemView.findViewById(R.id.roomlogo);
            txtduo = (TextView) itemView.findViewById(R.id.tvduo);
            txtroom = (TextView) itemView.findViewById(R.id.tvroom);
            layout = (LinearLayout) itemView.findViewById(R.id.layoutdevice);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deviceInterface.onClick(getAdapterPosition());

                }
            });

        }
    }
}
