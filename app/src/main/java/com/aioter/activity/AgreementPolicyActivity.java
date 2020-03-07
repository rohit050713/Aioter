package com.aioter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aioter.R;
import com.aioter.databinding.ActivityAgreementPolicyBinding;

public class AgreementPolicyActivity extends AppCompatActivity {
    ActivityAgreementPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agreement_policy);

        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgreementPolicyActivity.this, OnBoardingActivity.class));
            }
        });


        binding.tvPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.contentTermsCodition.setVisibility(View.GONE);
                binding.contentPrivacyPolicy.setVisibility(View.VISIBLE);
                binding.tvPrivacyPolicy.setTextColor(getResources().getColor(R.color.colorAccent));
                binding.tvTermsCodition.setTextColor(getResources().getColor(R.color.white));

                binding.tvPrivacyPolicy.setBackgroundColor(getResources().getColor(R.color.active_bg));
                binding.tvTermsCodition.setBackgroundColor(getResources().getColor(R.color.inactive_bg));
            }
        });
        binding.tvTermsCodition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.contentPrivacyPolicy.setVisibility(View.GONE);
                binding.contentTermsCodition.setVisibility(View.VISIBLE);
                binding.tvTermsCodition.setTextColor(getResources().getColor(R.color.colorAccent));
                binding.tvPrivacyPolicy.setTextColor(getResources().getColor(R.color.white));

                binding.tvTermsCodition.setBackgroundColor(getResources().getColor(R.color.active_bg));
                binding.tvPrivacyPolicy.setBackgroundColor(getResources().getColor(R.color.inactive_bg));
            }
        });

        binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // update your model (or other business logic) based on isChecked
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (binding.checkbox.isChecked()) {
                            startActivity(new Intent(AgreementPolicyActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                }, 1000);

            }
        });

    }
}
