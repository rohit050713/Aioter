package com.aioter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aioter.R;
import com.aioter.databinding.ActivityDeviceSwitchBinding;

public class DeviceSwitchActivity extends AppCompatActivity {

    ActivityDeviceSwitchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_device_switch);


        binding.savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DeviceSwitchActivity.this, "*Please add atleast 1 room.", Toast.LENGTH_SHORT).show();
            }
        });


        binding.lladdroomf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeviceSwitchActivity.this, AddRoomActivity.class);
                startActivityForResult(i, 1);
            }
        });

        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceSwitchActivity.this, ScanDevices.class));
                finish();
            }
        });
    }
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//        Bundle bundle = getIntent().getExtras();
//                String RoomName = bundle.getString("RoomName");
//            int whichIconSelected = bundle.getInt("whichIconSelected");
//            binding.addroom.setText(RoomName);
//            }
//        } }

}
