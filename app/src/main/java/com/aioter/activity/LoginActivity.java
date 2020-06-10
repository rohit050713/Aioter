package com.aioter.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aioter.R;
import com.aioter.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.skipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, TutorialActivity.class));
            }
        });
    }


    public void submit(View view){
        Intent i=new Intent(this,TutorialActivity.class);
        startActivity(i);
    }


public void google(View view){
    Intent intent = new Intent(LoginActivity.this, TutorialActivity.class);
    startActivity(intent);
    finish();
}

}
