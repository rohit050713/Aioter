package com.aioter.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aioter.R;
import com.aioter.databinding.ActivityDeviceHomeBinding;
import com.aioter.fragment.RoomFragment;
import com.aioter.fragment.SwitchOffFragment;
import com.aioter.fragment.SwitchedOnFragment;
import com.aioter.fragment.UnreachableFragment;
import com.google.android.material.tabs.TabLayout;

public class DeviceHomeActivity extends AppCompatActivity {

    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    ActivityDeviceHomeBinding binding;
    LinearLayout linearLayout_room;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_home);

        toolbar=findViewById(R.id.devicehome_toolbar);
        setSupportActionBar(toolbar);
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
        secondTab.setText("Switched On");// set the Text for the second Tab
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




//        ImageView backButton = findViewById(R.id.backbutton);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(DeviceHomeActivity.this, DeviceSwitchRoomActivity.class));
//                finish();
//            }
//        });

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

//        //for edit button of the  pin
//        ImageView editPin = findViewById(R.id.editPin);
//        editPin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogChangePin();
//            }
//        });


        //for wifi button
        ImageView wifibtn=findViewById(R.id.wifiBtn);
        wifibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog= new Dialog(DeviceHomeActivity.this);
                dialog.setContentView(R.layout.dialog_wifisetting);
                // close icon
                ImageView wifisetting_close= dialog.findViewById(R.id.wifi_setting_close);
                wifisetting_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //ok button
                final Button btn_wifisetting_ok= dialog.findViewById(R.id.btn_wifi_ok);
                final Button btn_wifisetting_camcel= dialog.findViewById(R.id.btn_wifi_cancel);

                btn_wifisetting_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                //cancel button
                btn_wifisetting_camcel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                dialog.setCancelable(false);
                if(dialog.getWindow()!=null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.show();
            }
        });
        //power button
        final ImageView poweroff_btn=findViewById(R.id.powerBtn);
        poweroff_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(DeviceHomeActivity.this);
                        dialog.setContentView(R.layout.dialog_device_poweroff);
                dialog.setCancelable(false);

                //close icon
                ImageView device_poweroff_close=dialog.findViewById(R.id.device_poweroff_close);
                device_poweroff_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button btn_device_poweroff_yes= dialog.findViewById(R.id.btn_devicepower_yes);
                btn_device_poweroff_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button btn_device_poweroff_no=dialog.findViewById(R.id.btn_devicepower_no);
                btn_device_poweroff_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                if(dialog.getWindow()!=null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.show();
            }

        });

        //kitchen room icon action
        linearLayout_room=findViewById(R.id.linearlayout_room);
        linearLayout_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poweroff_btn.setVisibility(View.GONE);
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                ft.replace(R.id.frame_layout,new RoomFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

                //pin click action
                RelativeLayout pin_layout= findViewById(R.id.pin_layout);
                pin_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        authentication();
                    }
                });

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

        ImageView dialogCloseButton = dialog.findViewById(R.id.change_pin_close);
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
                    errorpineditnew.setText("*Please enter a pin.");
                } else if (newpin.length() < 6) {
                    errorpineditnew.setVisibility(View.VISIBLE);
                    errorpineditnew.setText("*Min. Length: 6");
                } else if (confirmPin.length() < 1) {
                    errorpineditnew.setVisibility(View.GONE);
                    errorpineditconfirm.setVisibility(View.VISIBLE);
                    errorpineditconfirm.setText("*Please confirm a pin.");
                } else if (confirmPin.equals(newpin)) {
                    errorpineditnew.setVisibility(View.GONE);
                    errorpineditconfirm.setVisibility(View.GONE);
                    dialogSuccessfulPin();
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
                    errorpineditnew.setText("*Please enter a pin.");
                } else if (newpin.length() < 6) {
                    errorpineditnew.setVisibility(View.VISIBLE);
                    errorpineditnew.setText("*Min. Length: 6");
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
                    errorpineditconfirm.setText("*Please confirm a pin.");
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
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        dialog.show();
    }

    private void dialogSuccessfulPin() {
        final Dialog dialog = new Dialog(DeviceHomeActivity.this);
        dialog.setContentView(R.layout.dialog_successfully_changed_pin);
        dialog.setCancelable(false);

        ImageView cross = (ImageView) dialog.findViewById(R.id.successfully_changed_pin_close);
        // if button is clicked, close the custom dialog
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button okpinsucess = (Button) dialog.findViewById(R.id.btn_successpin_okay);
        // if button is clicked, close the custom dialog
        okpinsucess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_devicehome,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_devicehome:
                Intent i=new Intent(DeviceHomeActivity.this,ScanDevices.class);
                startActivity(i);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void authentication(){
        final Dialog dialog=new Dialog(DeviceHomeActivity.this);
        dialog.setContentView(R.layout.dialog_pin_authentication);

       final EditText et_pin= dialog.findViewById(R.id.et_pin);
        et_pin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView tv_pin=dialog.findViewById(R.id.tv_pin);
                String pin= et_pin.getText().toString().trim();
                if(pin.length()<6){
                    tv_pin.setVisibility(View.VISIBLE);
                }
                else{
                    tv_pin.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        dialog.setCancelable(false);
        //close icon
        ImageView close= dialog.findViewById(R.id.pin_authentication_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //button
        Button cancel=dialog.findViewById(R.id.btn_pinauthentication_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button ok=dialog.findViewById(R.id.btn_pinauthentication_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv_pin=dialog.findViewById(R.id.tv_pin);
                String pin= et_pin.getText().toString().trim();
                if(pin.length()<6){
                    tv_pin.setVisibility(View.VISIBLE);
                    return;
                }
                else {
                    dialog.dismiss();
                }
            }
        });
        if(dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.show();


        //forgot icon
        TextView forgot=dialog.findViewById(R.id.forgot_pinauthentication);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                final Dialog dialog1=new Dialog(DeviceHomeActivity.this);
                dialog1.setContentView(R.layout.dialog_user_authentication);

                 final EditText et_email=dialog1.findViewById(R.id.et_user_email);
                 et_email.addTextChangedListener(new TextWatcher() {
                     @Override
                     public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                     }

                     @Override
                     public void onTextChanged(CharSequence s, int start, int before, int count) {
                          String email= et_email.getText().toString().trim();
                          TextView tv_mail= dialog1.findViewById(R.id.tv_user);
                          if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                              tv_mail.setVisibility(View.VISIBLE);
                          }
                          else{
                              tv_mail.setVisibility(View.INVISIBLE);
                          }
                     }

                     @Override
                     public void afterTextChanged(Editable s) {

                     }
                 });
                dialog1.setCancelable(false);
                //close icon
                ImageView user_close=dialog1.findViewById(R.id.user_authentication_close);
                user_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });

                //button
                Button proceed=dialog1.findViewById(R.id.btn_userauthentication_proceed);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email= et_email.getText().toString().trim();
                        TextView tv_mail= dialog1.findViewById(R.id.tv_user);
                        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                            tv_mail.setVisibility(View.VISIBLE);
                            return;
                        }
                        else{
                            dialog1.dismiss();
                            dialog.show();
                            tv_mail.setVisibility(View.INVISIBLE);
                        }

                    }
                });

                if(dialog1.getWindow()!=null){
                    dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog1.show();
            }
        });
    }
}
