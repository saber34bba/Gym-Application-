package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import com.google.android.material.tabs.TabLayout;

import com.google.android.material.bottomappbar.BottomAppBar;


public class WeightLossActivity extends AppCompatActivity {
ImageView imageView;
    private ViewPager mViewPager;
TabLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss);
      //  imageView=findViewById(R.id.imageweight);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        tableLayout=findViewById(R.id.tabl);
  mViewPager=findViewById(R.id.xviewpager);



        ViewPagerAdapter mviewPagerAd=new ViewPagerAdapter(getSupportFragmentManager());
        mviewPagerAd.AddFr(new FragmentBeginnerWeightloss(),"Beginner");
        mviewPagerAd.AddFr(new FragmentIntermediateWeightloss(),"Intermediat");
        mviewPagerAd.AddFr(new FragmentExpertWeightloss(),"Expert");

        mViewPager.setAdapter(mviewPagerAd);
        tableLayout.setupWithViewPager(mViewPager);
    }
}
