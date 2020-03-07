package com.example.loginapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.loginapi.adapters.CustomPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

public class OnBoardingActivity extends AppCompatActivity {
CircleIndicator circleIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));


        circleIndicator = (CircleIndicator) findViewById(R.id.circleindicator_id);
        circleIndicator.setViewPager(viewPager);

        TextView skipTextView=findViewById(R.id.skipTextView);
        skipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OnBoardingActivity.this,
                        AgreementPolicyActivity.class);

                startActivity(i);
                finish();
            }
        });
    }
}
