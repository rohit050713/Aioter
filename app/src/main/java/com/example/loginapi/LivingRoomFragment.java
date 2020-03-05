package com.example.loginapi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LivingRoomFragment extends Fragment {
    View view;
    RoomRecyclerAdapter roomadapter;
    RecyclerView recyclerView;
    ArrayList<NewModel> newModels;


    public LivingRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_living_room, container, false);
        recyclerView  = view.findViewById(R.id.recyclerview2);
        Integer[] images ={R.drawable.layer_20_copy, R.drawable.layer_20_copy, R.drawable.layer_20_copy, R.drawable.layer_20_copy};
        String[] device = {"Stand Lamp", "Ceiling Fan", "Fridge", "Air Conditioner"};
        newModels = new ArrayList<>();
        for(int i=0; i<images.length;i++){
            NewModel model = new NewModel(images[i], device[i]);
            newModels.add(model);
        }
        LinearLayoutManager layoutManager, layoutManager1;
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        roomadapter = new RoomRecyclerAdapter(getContext(),newModels);
        recyclerView.setAdapter(roomadapter);
        return view;
    }

}
