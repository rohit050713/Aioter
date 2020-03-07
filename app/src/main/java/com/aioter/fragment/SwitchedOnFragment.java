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
import com.aioter.adapters.SwitchOnDeviceAdapter;
import com.aioter.models.RunningStateDeviceItemModal;

import java.util.ArrayList;
import java.util.List;

public class SwitchedOnFragment extends Fragment {
    List<RunningStateDeviceItemModal> deviceList = new ArrayList<RunningStateDeviceItemModal>();
    RecyclerView recyclerView;
    SwitchOnDeviceAdapter customRecyclerAdapter;
    public SwitchedOnFragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_switched_on, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        //setting the list inside the adapter
        customRecyclerAdapter = new SwitchOnDeviceAdapter(deviceList);
        //now putting the recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        //If you want to display a horizontal recycler view the use below line
        //  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customRecyclerAdapter);

//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(),   recyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
//
        for (int i = 0; i < 2; i++) {
            deviceList.add(new RunningStateDeviceItemModal("Stand Lamp",R.drawable.lamp_png));
            deviceList.add(new RunningStateDeviceItemModal("Ceiling Fan",R.drawable.fan_png));
            deviceList.add(new RunningStateDeviceItemModal("Fridge",R.drawable.fridge_png));
            deviceList.add(new RunningStateDeviceItemModal("Air Conditioner",R.drawable.ac_png));
        }
        customRecyclerAdapter.notifyDataSetChanged();


        // Inflate the layout for this fragment
        return view;
    }

}
