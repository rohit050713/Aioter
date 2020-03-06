package com.example.loginapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginapi.adapters.SwitchOffDeviceAdapter;
import com.example.loginapi.adapters.UnreachableDeviceAdapter;
import com.example.loginapi.models.RunningStateDeviceItemModal;

import java.util.ArrayList;
import java.util.List;


public class UnreachableFragment extends Fragment {
    List<RunningStateDeviceItemModal> deviceList = new ArrayList<RunningStateDeviceItemModal>();
    RecyclerView recyclerView;
    UnreachableDeviceAdapter customRecyclerAdapter;
    public UnreachableFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unreachable, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        //setting the list inside the adapter
        customRecyclerAdapter = new UnreachableDeviceAdapter(deviceList);
        //now putting the recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        //If you want to display a horizontal recycler view the use below line
        //  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customRecyclerAdapter);

        deviceList.add(new RunningStateDeviceItemModal("Fridge",R.drawable.fridge_png));
        deviceList.add(new RunningStateDeviceItemModal("Air Conditioner",R.drawable.ac_png));
        deviceList.add(new RunningStateDeviceItemModal("Ceiling Fan",R.drawable.fan_png));
        deviceList.add(new RunningStateDeviceItemModal("Fridge",R.drawable.fridge_png));
        deviceList.add(new RunningStateDeviceItemModal("Stand Lamp",R.drawable.lamp_png));
        deviceList.add(new RunningStateDeviceItemModal("Air Conditioner",R.drawable.ac_png));

        customRecyclerAdapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;
    }
}
