package com.aioter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aioter.adapters.myprofile_adapter;
import com.aioter.databinding.ActivityLoginBinding;
import com.aioter.databinding.ActivityMyprofileBinding;
import com.aioter.models.myprofile_model;

import com.aioter.R;

import java.util.ArrayList;
import java.util.List;

public class myprofile extends AppCompatActivity {

    public RecyclerView recyclerView;
    public myprofile_adapter myprofile_adapter;
    public List<myprofile_model> list;
    ActivityMyprofileBinding binding;

    public int image[]={R.drawable.delete_icon,R.drawable.delete_icon,R.drawable.delete_icon};
    public String name[]={"Raj","Rohit","Shubham"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_myprofile);
        Toolbar myprofile_toolbar= findViewById(R.id.myprofile_toolbar);
        setSupportActionBar(myprofile_toolbar);
        recyclerView=findViewById(R.id.myprofile_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        for(int i=0;i<image.length;i++) {
//    name[i] = getResources().getStringArray(R.array.myprofile_name);
    myprofile_model item = new myprofile_model(name[i], image[i]);
    list.add(item);

}



        myprofile_adapter =new myprofile_adapter(this,list);

        recyclerView.setAdapter(myprofile_adapter);


        binding.ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(myprofile.this);
                dialog.setContentView(R.layout.dialog_logout);
                dialog.setCancelable(false);

                ImageView imageView1= dialog.findViewById(R.id.logout_close);
                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                if(dialog.getWindow()!=null) {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.show();
            }
        });

    }
}
