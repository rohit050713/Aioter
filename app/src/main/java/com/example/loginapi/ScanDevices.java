package com.example.loginapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapi.adapters.DeviceItemAdapter;
import com.example.loginapi.databinding.ActivityScanDevicesBinding;
import com.example.loginapi.listener.RecyclerTouchListener;
import com.example.loginapi.models.DeviceItemModal;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ScanDevices extends AppCompatActivity {

    ActivityScanDevicesBinding binding;
    Boolean isScaning=false;

    List<DeviceItemModal> deviceList = new ArrayList<DeviceItemModal>();
    DeviceItemAdapter deviceItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_scan_devices);



        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScanDevices.this,LoginActivity.class));
                finish();
            }
        });
        binding.tvStopStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScaning){
                    binding.tvStopStart.setText("Scan");
                    isScaning=true;
                }else {
                    dialog();
                    binding.tvStopStart.setText("Stop");
                    isScaning=false;
                }            }
        });














        //setting the list inside the adapter
        deviceItemAdapter = new DeviceItemAdapter(deviceList);
        //now putting the recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //If you want to display a horizontal recycler view the use below line
        //  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

       binding.recyclerview.setLayoutManager(mLayoutManager);
        binding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerview.setAdapter(deviceItemAdapter);
//         //If you want to add a touchlistener to item then add below code and have to make a new class file those code is in step6
        binding.recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),   binding.recyclerview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                dialog();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        //Below is a simple method to populate data
        prepareData();













    }

    private void prepareData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                deviceList.add(new DeviceItemModal("Device Name", "Device Sr.Number", "Switches- 4+1 dimmer"));
                deviceList.add(new DeviceItemModal("Device Name", "Device Sr.Number", "Switches- 4+1 dimmer"));
                deviceList.add(new DeviceItemModal("Device Name", "Device Sr.Number", "Switches- 4+1 dimmer"));
                deviceList.add(new DeviceItemModal("Device Name", "Device Sr.Number", "Switches- 4+1 dimmer"));


                deviceItemAdapter.notifyDataSetChanged();
            }
        },4000);

    }

    private void dialog() {
        final Dialog dialog = new Dialog(ScanDevices.this);
        dialog.setContentView(R.layout.alertdialog);
        dialog.setCancelable(false);
final TextView errortvPin=dialog.findViewById(R.id.errortvDevicePin);


        final EditText editTextDevicePin=dialog.findViewById(R.id.etDevicePin);
        editTextDevicePin.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String pin = editTextDevicePin.getText().toString().trim();
                if (pin.length()<4) {
                    errortvPin.setVisibility(View.VISIBLE);
                    errortvPin.setText("*Device pin must be of 4 charaters.");


                } else if (Pattern.compile("1234").matcher(pin).matches()) {
                    errortvPin.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(ScanDevices.this,DeviceSwitchActivity.class));

                } else {
                    errortvPin.setVisibility(View.VISIBLE);
                    errortvPin.setText("*Please enter a valid device pin.");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ImageView dialogCloseButton = dialog.findViewById(R.id.ivClose);
        // if button is clicked, close the custom dialog
        dialogCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvStopStart.setText("Scan");
                dialog.dismiss();
            }
        });
        if(dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.show();

    }
}
