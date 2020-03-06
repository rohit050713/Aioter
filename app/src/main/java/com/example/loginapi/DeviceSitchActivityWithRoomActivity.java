package com.example.loginapi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.loginapi.databinding.ActivityDeviceSitchWithRoomBinding;


public class DeviceSitchActivityWithRoomActivity extends AppCompatActivity {

    ActivityDeviceSitchWithRoomBinding binding;

    int whichIconSelected;
    String RoomName;
    String inputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_device_sitch_with_room);
//        Bundle bundle = getIntent().getExtras();
//        if (bundle.containsKey(AddRoomActivity.input)) {
//             RoomName = bundle.getString("RoomName");
//             whichIconSelected = bundle.getInt("whichIconSelected");
//            binding.addroom.setText(RoomName);
//        }


        binding.switch1Lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch1Lamp.setImageResource(R.drawable.lamp_icon);
                binding.switch1Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch1Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch1Bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch1Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch1Bulb.setImageResource(R.drawable.bulb_icon);
                binding.switch1Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch1Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch1Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch1Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch1Fan.setImageResource(R.drawable.fan_icon);
            }
        });

        binding.switch2Lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch2Lamp.setImageResource(R.drawable.lamp_icon);
                binding.switch2Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch2Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch2Bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch2Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch2Bulb.setImageResource(R.drawable.bulb_icon);
                binding.switch2Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch2Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch2Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch2Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch2Fan.setImageResource(R.drawable.fan_icon);
            }
        });

        binding.switch3Lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch3Lamp.setImageResource(R.drawable.lamp_icon);
                binding.switch3Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch3Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch3Bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch3Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch3Bulb.setImageResource(R.drawable.bulb_icon);
                binding.switch3Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch3Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch3Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch3Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch3Fan.setImageResource(R.drawable.fan_icon);
            }
        });

        binding.switch4Lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch4Lamp.setImageResource(R.drawable.lamp_icon);
                binding.switch4Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch4Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch4Bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch4Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch4Bulb.setImageResource(R.drawable.bulb_icon);
                binding.switch4Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch4Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch4Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch4Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch4Fan.setImageResource(R.drawable.fan_icon);
            }
        });

        binding.switch5Lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch5Lamp.setImageResource(R.drawable.lamp_icon);
                binding.switch5Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch5Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch5Bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch5Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch5Bulb.setImageResource(R.drawable.bulb_icon);
                binding.switch5Fan.setImageResource(R.drawable.fan_icon_white);
            }
        });
        binding.switch5Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.switch5Lamp.setImageResource(R.drawable.lamp_icon_white);
                binding.switch5Bulb.setImageResource(R.drawable.bulb_icon_white);
                binding.switch5Fan.setImageResource(R.drawable.fan_icon);
            }
        });


        binding.switch1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.switch1EditText.getText().toString().trim().length() < 1) {
                    binding.errorSwitch1.setVisibility(View.VISIBLE);
                    binding.errorSwitch1.setText("Please enter switch name.");
                } else if (binding.switch1EditText.getText().toString().trim().length() < 2) {
                    binding.errorSwitch1.setVisibility(View.VISIBLE);
                    binding.errorSwitch1.setText("Please enter valid switch name.");
                } else {
                    binding.errorSwitch1.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.switch2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {if (binding.switch2EditText.getText().toString().trim().length() < 1) {
                binding.errorSwitch2.setVisibility(View.VISIBLE);
                binding.errorSwitch2.setText("Please enter switch name.");
            } else if (binding.switch2EditText.getText().toString().trim().length()  < 2) {
                binding.errorSwitch2.setVisibility(View.VISIBLE);
                binding.errorSwitch2.setText("Please enter valid switch name.");
            } else {
                binding.errorSwitch2.setVisibility(View.GONE);
            }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.switch3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.switch3EditText.getText().toString().trim().length() < 1) {
                    binding.errorSwitch3.setVisibility(View.VISIBLE);
                    binding.errorSwitch3.setText("Please enter switch name.");
                } else if (binding.switch3EditText.getText().toString().trim().length()  < 2) {
                    binding.errorSwitch3.setVisibility(View.VISIBLE);
                    binding.errorSwitch3.setText("Please enter valid switch name.");
                } else {
                    binding.errorSwitch3.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.switch4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (binding.switch4EditText.getText().toString().trim().length() < 1) {
                    binding.errorSwitch4.setVisibility(View.VISIBLE);
                    binding.errorSwitch4.setText("Please enter switch name.");
                } else if (binding.switch4EditText.getText().toString().trim().length() < 2) {
                    binding.errorSwitch4.setVisibility(View.VISIBLE);
                    binding.errorSwitch4.setText("Please enter valid switch name.");
                } else {
                    binding.errorSwitch4.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        binding.switch5EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                inputEditText = binding.switch5EditText.getText().toString().trim();
                if (inputEditText.length() < 1) {
                    binding.errorSwitch5.setVisibility(View.VISIBLE);
                    binding.errorSwitch5.setText("Please enter switch name.");
                } else if (binding.switch5EditText.getText().toString().trim().length() < 2) {
                    binding.errorSwitch5.setVisibility(View.VISIBLE);
                    binding.errorSwitch5.setText("Please enter valid switch name.");
                } else {
                    binding.errorSwitch5.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceSitchActivityWithRoomActivity.this, ScanDevices.class));
                finish();
            }
        });


        binding.savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceSitchActivityWithRoomActivity.this, DeviceHomeActivity.class));
            }
        });
    }


}
