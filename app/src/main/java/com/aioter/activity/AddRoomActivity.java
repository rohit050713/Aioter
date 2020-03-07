package com.aioter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aioter.R;
import com.aioter.databinding.ActivityAddRoomBinding;

public class AddRoomActivity extends AppCompatActivity {
    public static String RoomName;
    String input;
    int whichRoomIcon = 1;
    ActivityAddRoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_room);

        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddRoomActivity.this, DeviceSwitchActivity.class));
                finish();
            }
        });
        binding.roomIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.roomIcon1.setImageResource(R.drawable.room_icon_one);
                binding.roomIcon2.setImageResource(R.drawable.room_icon_two_white);
                binding.roomIcon3.setImageResource(R.drawable.room_icon_three_white);
                binding.roomIcon4.setImageResource(R.drawable.room_icon_four_white);
                binding.roomIcon5.setImageResource(R.drawable.room_icon_five_white);
                whichRoomIcon = 1;
            }
        });
        binding.roomIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.roomIcon1.setImageResource(R.drawable.room_icon_one_white);
                binding.roomIcon2.setImageResource(R.drawable.room_icon_two);
                binding.roomIcon3.setImageResource(R.drawable.room_icon_three_white);
                binding.roomIcon4.setImageResource(R.drawable.room_icon_four_white);
                binding.roomIcon5.setImageResource(R.drawable.room_icon_five_white);
                whichRoomIcon = 2;
            }
        });
        binding.roomIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.roomIcon1.setImageResource(R.drawable.room_icon_one_white);
                binding.roomIcon2.setImageResource(R.drawable.room_icon_two_white);
                binding.roomIcon3.setImageResource(R.drawable.room_icon_three);
                binding.roomIcon4.setImageResource(R.drawable.room_icon_four_white);
                binding.roomIcon5.setImageResource(R.drawable.room_icon_five_white);
                whichRoomIcon = 3;
            }
        });
        binding.roomIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.roomIcon1.setImageResource(R.drawable.room_icon_one_white);
                binding.roomIcon2.setImageResource(R.drawable.room_icon_two_white);
                binding.roomIcon3.setImageResource(R.drawable.room_icon_three_white);
                binding.roomIcon4.setImageResource(R.drawable.room_icon_four);
                binding.roomIcon5.setImageResource(R.drawable.room_icon_five_white);
                whichRoomIcon = 4;
            }
        });
        binding.roomIcon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.roomIcon1.setImageResource(R.drawable.room_icon_one_white);
                binding.roomIcon2.setImageResource(R.drawable.room_icon_two_white);
                binding.roomIcon3.setImageResource(R.drawable.room_icon_three_white);
                binding.roomIcon4.setImageResource(R.drawable.room_icon_four_white);
                binding.roomIcon5.setImageResource(R.drawable.room_icon_five);
                whichRoomIcon = 5;
            }
        });

        binding.etRoomName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isName();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isName()) {
                    Intent intent = new Intent(AddRoomActivity.this, DeviceSwitchRoomActivity.class);
                    startActivity(intent);
//
//                  Bundle extras = new Bundle();
//                   extras.putString("RoomName",input);
//                   extras.putInt("whichIconSelected", whichRoomIcon);
//
//                   Intent intent = new Intent();
//                   intent.putExtras(extras);
//                   setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    Boolean isName() {
        input = binding.etRoomName.getText().toString().trim();
        if (input.length() < 1) {
            binding.errorName.setVisibility(View.VISIBLE);
            binding.errorName.setText("*Please enter room name.");
            return false;
        } else if (input.length() < 2) {
            binding.errorName.setVisibility(View.VISIBLE);
            binding.errorName.setText("*Please enter valid room name.");

            return false;
        } else {
            binding.errorName.setVisibility(View.GONE);

            return true;
        }
    }
}
