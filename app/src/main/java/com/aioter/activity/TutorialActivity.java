package com.aioter.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aioter.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TutorialActivity extends AppCompatActivity{
    View view;
    MapView mapView;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_acitivity);

        Button btn1 = (Button) findViewById(R.id.btscan);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, ScanDevices.class);
                startActivity(intent);
                finish();
            }
        });


// add home dialog box
        Button btn2= (Button) findViewById(R.id.btn_createhome);
      btn2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            dialog= new Dialog(TutorialActivity.this);
              //search view for map
              EditText et1_addhome= (EditText) dialog.findViewById(R.id.et1_addhome);
              EditText et2_addhome= (EditText) dialog.findViewById(R.id.et2_addhome);



              dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

              dialog.setContentView(R.layout.dialog_addhome);
              dialog.setCancelable(false);



//map code
              mapView=dialog.findViewById(R.id.map);
              MapsInitializer.initialize(getApplicationContext());

              mapView.onCreate(dialog.onSaveInstanceState());

              mapView.onResume();
              mapView.getMapAsync(new OnMapReadyCallback() {
                  @Override
                  public void onMapReady(final GoogleMap googleMap) {

                      LatLng latLng= new LatLng(28.6289206,77.2065322);
                      googleMap.addMarker(new MarkerOptions().position(latLng).title("you are here"));
                      googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                      googleMap.getUiSettings().setZoomControlsEnabled(true);
                      googleMap.getUiSettings().setMyLocationButtonEnabled(false);
                      googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

                  }
              });

             // continue button action
              Button btn_continue=dialog.findViewById(R.id.btn_addhome_continue);

              btn_continue.setOnClickListener(new View.OnClickListener() {
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

