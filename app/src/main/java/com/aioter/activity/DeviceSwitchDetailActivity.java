package com.aioter.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.aioter.R;
import com.aioter.adapters.SpinnerAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class DeviceSwitchDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    BarChart barChart;
    ArrayList<BarEntry> barentries;
    Spinner spinner1,spinner2;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_switch_detail);

        //for toolbar
        toolbar=findViewById(R.id.device_detail_toolbar);
        setSupportActionBar(toolbar);

        ImageView backbtn=findViewById(R.id.device_detail_back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DeviceSwitchDetailActivity.this,DeviceHomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        spinner();

        graph();



    }
    public void spinner(){
        // for spinners
        spinner1=findViewById(R.id.device_switch_spinner1);
        String [] years={"Year","1999","2000","2001","2002"};

        SpinnerAdapter adapter=new SpinnerAdapter(this,R.layout.spinner_device_switch,years);
        spinner1.setAdapter(adapter);


        spinner2=findViewById(R.id.device_switch_spinner2);
        String [] month={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        SpinnerAdapter adapter2=new SpinnerAdapter(this,R.layout.spinner_device_switch,month);
        spinner2.setAdapter(adapter2);
    }

    public void graph(){
        //for the graph
        barChart= findViewById(R.id.bar_chart);
//for entries
        getentries();

        BarDataSet dataSet=new BarDataSet(barentries,"datasets");

        //x axis values
        final ArrayList<String> xaxislabel=new ArrayList<>();
        xaxislabel.add("Mon");
        xaxislabel.add("Tue");
        xaxislabel.add("Wed");
        xaxislabel.add("Thu");
        xaxislabel.add("Fri");
        xaxislabel.add("Sat");
        xaxislabel.add("Sun");

        BarData data=new BarData(dataSet);

        data.setBarWidth(0.7f);  // for setting bar width
        dataSet.setDrawValues(false);//for hiding the value on th top of bar

        Paint p1 = barChart.getPaint(Chart.PAINT_GRID_BACKGROUND);
        p1.setColor(Color.CYAN);


        barChart.setFitBars(true);
        barChart.getLegend().setEnabled(false); // for hiding the label

        //for x and y axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);


        xAxis.setValueFormatter(new IndexAxisValueFormatter(xaxislabel));//for setting the x axis values


        YAxis left = barChart.getAxisLeft();
//        left.setDrawLabels(); // no axis labels
//        left.setDrawAxisLine(false); // no axis line
        left.setDrawGridLines(false); // no grid lines
        left.setDrawZeroLine(true);// draw a zero line
        left.setTextColor(Color.WHITE);
        left.setDrawAxisLine(true);
        left.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        barChart.getAxisRight().setEnabled(false);

        barChart.setData(data);
        dataSet.setColor(getResources().getColor(R.color.selected));
    }

    //for graph entries
    public void getentries(){
        barentries= new ArrayList<>();
        barentries.add(new BarEntry(0f,20));
        barentries.add(new BarEntry(1f,16));
        barentries.add(new BarEntry(2f,12));
        barentries.add(new BarEntry(3f,15));
        barentries.add(new BarEntry(4f,14));
        barentries.add(new BarEntry(5f,18));
        barentries.add(new BarEntry(6f,5));




    }
//for toolbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_device_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.device_detail_edit:
               Intent i=new Intent(DeviceSwitchDetailActivity.this,EditSwitchActivity.class);
               startActivity(i);
               break;
           case R.id.device_detail_delete:
              delete();
               break;

       }
        return super.onOptionsItemSelected(item);
    }

    public void delete(){
        dialog = new Dialog(DeviceSwitchDetailActivity.this);
        dialog.setContentView(R.layout.dialog_deleteswitch);
        dialog.setCancelable(false);
        ImageView close = (ImageView) dialog.findViewById(R.id.delete_switch_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(DeviceSwitchDetailActivity.this, DeviceHomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btn_yes = (Button) dialog.findViewById(R.id.btn_deleteswitch_yes);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DeviceSwitchDetailActivity.this, DeviceHomeActivity.class);
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
    }
// removing memory leak in dialog
    @Override
    protected void onPause() {
        super.onPause();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
