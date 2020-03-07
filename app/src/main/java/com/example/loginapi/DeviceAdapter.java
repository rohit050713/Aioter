package com.example.loginapi;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

     Dialog myDialog;
     private String[] data;
     Context mContext;
     public DeviceAdapter(Context mContext, String[] data){
          this.mContext = mContext;
          this.data = data;
     }

     public DeviceAdapter(String[] list) {
     }

     @NonNull
     @Override
     public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          LayoutInflater inflater = LayoutInflater.from(parent.getContext());
          View view = inflater.inflate(R.layout.list_item_layout,parent,false);

          DeviceViewHolder dholder = new DeviceViewHolder(view);
          myDialog = new Dialog(mContext);
          myDialog.setContentView(R.layout.dialog_device_item_login);
          dholder.contact_item.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
          });


          return new DeviceViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
          String title = data[position];
          holder.txt.setText(title);


     }

     @Override
     public int getItemCount() {
          return data.length;
     }

     public class DeviceViewHolder extends RecyclerView.ViewHolder{

          LinearLayout contact_item;
          ImageView imgicon;
          TextView txt;
          TextView textView1;
          public DeviceViewHolder(@NonNull View itemView) {
               super(itemView);
               contact_item = (LinearLayout) itemView.findViewById(R.id.item_contact);
               imgicon= (ImageView) itemView.findViewById(R.id.imgicon);
               txt = (TextView) itemView.findViewById(R.id.tvdevices);
               textView1 = (TextView) itemView.findViewById(R.id.tviconarrow);

          }
     }
     public interface OnNoteListener{
          void onNoteClick(int position);
     }
}
