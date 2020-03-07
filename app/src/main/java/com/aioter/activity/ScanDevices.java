package com.aioter.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.R;
import com.aioter.adapters.DeviceItemAdapter;
import com.aioter.databinding.ActivityScanDevicesBinding;
import com.aioter.listener.RecyclerTouchListener;
import com.aioter.models.DeviceItemModal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ScanDevices extends AppCompatActivity {

    ActivityScanDevicesBinding binding;
    Boolean isScaning = false;

    List<DeviceItemModal> deviceList = new ArrayList<DeviceItemModal>();
    DeviceItemAdapter deviceItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan_devices);


        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScanDevices.this, LoginActivity.class));
                finish();
            }
        });
        binding.tvStopStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScaning) {
                    binding.tvStopStart.setText("Scan");
                    isScaning = true;
                } else {
                    dialog();
                    binding.tvStopStart.setText("Stop");
                    isScaning = false;
                }
            }
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
        binding.recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerview, new RecyclerTouchListener.ClickListener() {
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
        }, 3000);

    }

    private void dialog() {
        final Dialog dialog = new Dialog(ScanDevices.this);
        dialog.setContentView(R.layout.dialog_device_item_login);
        dialog.setCancelable(false);
        final TextView errortvPin = dialog.findViewById(R.id.errortvDevicePin);


        final EditText editTextDevicePin = dialog.findViewById(R.id.etDevicePin);
        editTextDevicePin.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String pin = editTextDevicePin.getText().toString().trim();
                if (pin.length() < 1) {
                    errortvPin.setVisibility(View.VISIBLE);
                    errortvPin.setText("*Please enter device pin.");


                } else if (pin.length() < 6) {
                    errortvPin.setVisibility(View.VISIBLE);
                    errortvPin.setText("*Please enter valid device pin.");


                } else if (Pattern.compile("123456").matcher(pin).matches()) {
                    errortvPin.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(ScanDevices.this, DeviceSwitchActivity.class));
                    dialog.dismiss();

                } else {
                    errortvPin.setVisibility(View.VISIBLE);
                    errortvPin.setText("*Device pin not matched.");
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
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.show();

    }
}
