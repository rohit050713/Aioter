package com.example.loginapi;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomRecyclerAdapter extends RecyclerView.Adapter<RoomRecyclerAdapter.ViewHolder> {
    ArrayList<NewModel>newModels;
    Context context;
    public RoomRecyclerAdapter(Context context, ArrayList<NewModel>newModels){
        this.context = context;
        this.newModels = newModels;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.room_layout, parent,false);
        RoomRecyclerAdapter.ViewHolder vholder =new RoomRecyclerAdapter.ViewHolder(view);
        return new RoomRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(newModels.get(position).getRoomLogo());
        holder.textView.setText(newModels.get(position).getDeviceType());

    }

    @Override
    public int getItemCount() {
        return newModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imglogo);
            textView = (TextView) itemView.findViewById(R.id.devicetype);

        }
    }
}
