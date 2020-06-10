package com.aioter.fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.aioter.R;
import com.aioter.adapters.SpinnerAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFragment extends Fragment {

    private Spinner spinner1;
    private Spinner spinner2;
    private static  BarChart barChart;
    private static ArrayList<BarEntry> barentries;

    public RoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_room, container, false);
       //for spinner
        spinner1=view.findViewById(R.id.room_fragment_spinner1);
        String [] years={"Year","1999","2000","2001","2002"};

        SpinnerAdapter adapter=new SpinnerAdapter(view.getContext(),R.layout.spinner_device_switch,years);
        spinner1.setAdapter(adapter);


        spinner2=view.findViewById(R.id.room_fragment_spinner2);
        String [] month={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        SpinnerAdapter adapter2=new SpinnerAdapter(view.getContext(),R.layout.spinner_device_switch,month);
        spinner2.setAdapter(adapter2);

        //for the graph
        barChart= view.findViewById(R.id.room_fragment_bar_chart);
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




        // Inflate the layout for this fragment
        return view;
    }
    //for graph entries
    private void getentries(){
        barentries= new ArrayList<>();
        barentries.add(new BarEntry(0f,20));
        barentries.add(new BarEntry(1f,16));
        barentries.add(new BarEntry(2f,12));
        barentries.add(new BarEntry(3f,15));
        barentries.add(new BarEntry(4f,14));
        barentries.add(new BarEntry(5f,18));
        barentries.add(new BarEntry(6f,5));




    }


}
