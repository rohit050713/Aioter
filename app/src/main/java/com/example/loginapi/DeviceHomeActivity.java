package com.example.loginapi;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.loginapi.databinding.ActivityDeviceHomeBinding;
import com.google.android.material.tabs.TabLayout;

public class DeviceHomeActivity extends AppCompatActivity {

    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    ActivityDeviceHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_home);
        Fragment fragment = new SwitchedOnFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.simpleFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
        simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);
// Create a new Tab named "First"
        final TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Switched On"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.switched_on_icon); // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Switched On"); // set the Text for the second Tab
        secondTab.setIcon(R.drawable.switched_off_icon); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Unreachable");
        thirdTab.setIcon(R.drawable.switched_unreachable_icon);
        tabLayout.addTab(thirdTab);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
// get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = new SwitchedOnFragment();
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new SwitchedOnFragment();
                        break;
                    case 1:
                        fragment = new SwitchOffFragment();
                        break;
                    case 2:
                        fragment = new UnreachableFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        TextView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceHomeActivity.this, DeviceSitchActivityWithRoomActivity.class));
                finish();
            }
        });

        ImageView homeIcon = findViewById(R.id.homeIcon);
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceHomeActivity.this, HomeActivity.class));
                finish();
            }
        });


        ImageView editRoom = findViewById(R.id.editRoom);
        editRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogChangePin();
            }
        });

        ImageView editPin = findViewById(R.id.editPin);
        editPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dialogChangePin();
            }
        });

    }

    private void dialogChangePin() {
        final Dialog dialog = new Dialog(DeviceHomeActivity.this);
        dialog.setContentView(R.layout.dialog_change_pin);
        dialog.setCancelable(false);


        final EditText pineditnew = dialog.findViewById(R.id.pineditnew);
        final EditText pineditconfirm = dialog.findViewById(R.id.pineditconfirm);
        final TextView errorpineditnew = dialog.findViewById(R.id.errorpinnew);
        final TextView errorpineditconfirm = dialog.findViewById(R.id.errorpinconfirm);

        ImageView dialogCloseButton = dialog.findViewById(R.id.changepincross);
        // if button is clicked, close the custom dialog
        dialogCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button laterButton = (Button) dialog.findViewById(R.id.pinchangelater);
        // if button is clicked, close the custom dialog
        laterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button updateButton = (Button) dialog.findViewById(R.id.updatepin);
        // if button is clicked, close the custom dialog
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newpin = pineditnew.getText().toString().trim();
                String confirmPin = pineditconfirm.getText().toString().trim();
                if (newpin.length() < 1) {
                    errorpineditnew.setVisibility(View.VISIBLE);
                    errorpineditnew.setText("*Please enter pin");
                } else if (newpin.length() < 6) {
                    errorpineditnew.setVisibility(View.VISIBLE);
                    errorpineditnew.setText("*Length of pin must be atleast 6");
                } else if (confirmPin.length() < 1) {
                    errorpineditnew.setVisibility(View.GONE);
                    errorpineditconfirm.setVisibility(View.VISIBLE);
                    errorpineditconfirm.setText("*Please confirm pin");
                } else if (confirmPin.equals(newpin)) {
                    errorpineditnew.setVisibility(View.GONE);
                    errorpineditconfirm.setVisibility(View.GONE);
                    dialigSuccefullyPin();
                    dialog.dismiss();
                } else {
                    errorpineditconfirm.setVisibility(View.VISIBLE);
                    errorpineditconfirm.setText("*Confirm pin not matched.");
                }
            }
        });
        pineditnew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               String newpin = pineditnew.getText().toString().trim();
                if (newpin.length() < 1) {
                    errorpineditnew.setVisibility(View.VISIBLE);
                    errorpineditnew.setText("*Please enter pin");
                } else if (newpin.length() < 6) {
                    errorpineditnew.setVisibility(View.VISIBLE);
                    errorpineditnew.setText("*Length of pin must be atleast 6");
                } else {
                    errorpineditnew.setVisibility(View.GONE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        pineditconfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String confirmPin = pineditconfirm.getText().toString().trim();
                String newpin = pineditnew.getText().toString().trim();
                if (confirmPin.length() < 1) {
                    errorpineditconfirm.setVisibility(View.VISIBLE);
                    errorpineditconfirm.setText("*Please confirm pin");
                } else if (confirmPin.equals(newpin)) {
                    errorpineditconfirm.setVisibility(View.GONE);

                } else {
                    errorpineditconfirm.setVisibility(View.VISIBLE);
                    errorpineditconfirm.setText("*Confirm pin not matched.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        if (dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        dialog.show();
    }

    private void dialigSuccefullyPin() {
        final Dialog dialog = new Dialog(DeviceHomeActivity.this);
        dialog.setContentView(R.layout.dialog_successfully_changed_pin);
        dialog.setCancelable(false);


        ImageView cross = (ImageView) dialog.findViewById(R.id.changepinsucesscross);
        // if button is clicked, close the custom dialog
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button okpinsucess = (Button) dialog.findViewById(R.id.okpinsucess);
        // if button is clicked, close the custom dialog
        okpinsucess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        if (dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        dialog.show();

    }
}
