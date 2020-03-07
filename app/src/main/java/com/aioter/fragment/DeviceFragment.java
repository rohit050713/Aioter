package com.aioter.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aioter.MainModel;
import com.aioter.R;
import com.aioter.adapters.RecyclerAdapter;
import com.aioter.listener.DeviceInterface;

import java.util.ArrayList;

public class DeviceFragment extends Fragment implements DeviceInterface {

    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    LivingRoomFragment livingRoomFragment;
    View view;


    public DeviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_device, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        Integer[] images = {R.drawable.layer_20_copy, R.drawable.layer_20_copy, R.drawable.layer_20_copy, R.drawable.layer_20_copy};
        String[] textDuo = {"Duo", "Quad", "Smart Plug(5A)", "Four+1"};
        String[] textroom = {"Living Room", "Bedroom", "DiningRoom", "Kitchen"};
        mainModels = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            MainModel model = new MainModel(images[i], textDuo[i], textroom[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager, layoutManager1;
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerAdapter = new RecyclerAdapter(getContext(), mainModels, this);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onClick(int position) {
        TextView txtduo, txtroom;
        txtduo = (TextView) view.findViewById(R.id.tvduo);
        txtroom = (TextView) view.findViewById(R.id.tvroom);
        txtduo.setTextColor(Color.parseColor("#f47733"));
        txtroom.setTextColor(Color.parseColor("#f47733"));
        livingRoomFragment = new LivingRoomFragment();
        if (position == 0) {

            setFragment(livingRoomFragment);
        }

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout1, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
