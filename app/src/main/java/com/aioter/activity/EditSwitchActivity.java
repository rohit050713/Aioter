package com.aioter.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.aioter.R;

public class EditSwitchActivity extends AppCompatActivity {

    Toolbar toolbar;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_switch);

        toolbar=findViewById(R.id.edit_switch_toolbar);
        setSupportActionBar(toolbar);
//back imageview
        ImageView back_btn= (ImageView) findViewById(R.id.edit_switch_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditSwitchActivity.this,DeviceSwitchDetailActivity.class);
                startActivity(i);
                finish();
            }
        });
        //update button
        Button update= findViewById(R.id.btn_edit_switch_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditSwitchActivity.this,DeviceSwitchDetailActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_edit_switch,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit_switch_delete:
                dialog = new Dialog(EditSwitchActivity.this);
                dialog.setContentView(R.layout.dialog_deleteswitch);
                dialog.setCancelable(false);
                ImageView close = (ImageView) dialog.findViewById(R.id.delete_switch_close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent i = new Intent(EditSwitchActivity.this, DeviceHomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                });

                Button btn_yes = (Button) dialog.findViewById(R.id.btn_deleteswitch_yes);
                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(EditSwitchActivity.this, DeviceHomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                Button btn_no = (Button) dialog.findViewById(R.id.btn_deleteswitch_no);
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                if(dialog.getWindow()!=null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //for removing memory leak error in dialog

    @Override
    protected void onPause() {
        super.onPause();
        if (dialog != null) {
            dialog.dismiss();
        }

    }
}
