package com.aioter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.R;
import com.aioter.adapters.SwitchOffDeviceAdapter;
import com.aioter.models.RunningStateDeviceItemModal;

import java.util.ArrayList;
import java.util.List;


public class SwitchOffFragment extends Fragment {
    List<RunningStateDeviceItemModal> deviceList = new ArrayList<RunningStateDeviceItemModal>();
    RecyclerView recyclerView;
    SwitchOffDeviceAdapter customRecyclerAdapter;
    public SwitchOffFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_switch_off, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        //setting the list inside the adapter
        customRecyclerAdapter = new SwitchOffDeviceAdapter(deviceList);
        //now putting the recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        //If you want to display a horizontal recycler view the use below line
        //  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customRecyclerAdapter);

            deviceList.add(new RunningStateDeviceItemModal("Stand Lamp",R.drawable.lamp_png));
            deviceList.add(new RunningStateDeviceItemModal("Ceiling Fan",R.drawable.fan_png));
            deviceList.add(new RunningStateDeviceItemModal("Fridge",R.drawable.fridge_png));
            deviceList.add(new RunningStateDeviceItemModal("Air Conditioner",R.drawable.ac_png));

        customRecyclerAdapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;
    }
}