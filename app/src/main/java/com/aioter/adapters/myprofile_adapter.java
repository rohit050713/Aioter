package com.aioter.adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aioter.models.myprofile_model;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.aioter.R;

import java.util.ArrayList;
import java.util.List;

public class myprofile_adapter extends RecyclerView.Adapter<myprofile_adapter.MyViewHolder>{
    private Context context;
    private List<myprofile_model> list=new ArrayList<>();

    public myprofile_adapter(Context context, List<myprofile_model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.myprofile_content, parent, false);



        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        myprofile_model item= (myprofile_model) list.get(position);

        holder.name.setText(item.getName());
        holder.images.setImageResource(item.getImages());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView images;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);

            images = itemView.findViewById(R.id.iv_myprofile);
        }
    }





}
