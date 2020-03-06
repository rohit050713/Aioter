package com.example.loginapi;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.loginapi.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new LivingRoomFragment();
    final Fragment fragment3 = new HomeFragment();
    final Fragment fragment4 = new LivingRoomFragment();
    final Fragment fragment5 = new HomeFragment();
    final FragmentManager fm = getSupportFragmentManager();
    ActivityHomeBinding binding;
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);


        fm.beginTransaction().add(R.id.homeplaceholder, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.homeplaceholder, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.homeplaceholder, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.homeplaceholder, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.homeplaceholder, fragment1, "1").commit();
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeuncolor:
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;

                    case R.id.chairbottom:
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;

                    case R.id.clock:
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment2;
                        return true;

                    case R.id.wifi:
                        fm.beginTransaction().hide(active).show(fragment4).commit();
                        active = fragment2;
                        return true;

                    case R.id.setting:
                        fm.beginTransaction().hide(active).show(fragment5).commit();
                        active = fragment3;
                        return true;
                }
                return false;
            }
        };

        binding.homeuncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}