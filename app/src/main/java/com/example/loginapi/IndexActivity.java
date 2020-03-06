package com.example.loginapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.loginapi.databinding.ActivityIndexBinding;

public class IndexActivity extends AppCompatActivity {

    ActivityIndexBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }
}
