package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTableLayout;
    private ViewPager mxViewPager;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        mTableLayout=(TabLayout) findViewById(R.id.tabl);
        mxViewPager=findViewById(R.id.xviewpager);
       img=findViewById(R.id.graphxml);
       img.setScaleX(0f);
       img.setScaleX(0f);
        ViewPagerAdapter mviewPagerAd=new ViewPagerAdapter(getSupportFragmentManager());
        mviewPagerAd.AddFr(new FragmentGym(),"Gym");
        mviewPagerAd.AddFr(new FragmentRunning(),"Running");
        mviewPagerAd.AddFr(new FragmentGym(),"Courses");

        mxViewPager.setAdapter(mviewPagerAd);
        mTableLayout.setupWithViewPager(mxViewPager);



        ViewGroup vg = (ViewGroup) mTableLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int i = 0; i < tabsCount; i++)
        {
            int delay = (i * 100) + 350; //this is starting delay
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(i);


            vgTab.setScaleX(0f);
            vgTab.setScaleY(0f);
            vgTab.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setStartDelay(delay)
                    .setInterpolator(new FastOutSlowInInterpolator())
                    .setDuration(450)
                    .start();
        }




        mxViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                 if(positionOffset!=0 )
                 {
                     hideicon();
                 }

            }

            @Override
            public void onPageSelected(int position) {
                if(mxViewPager.getCurrentItem()==1)
                {
                    //Toast.makeText(MainActivity.this, "sss", Toast.LENGTH_SHORT).show();
                   animicon();
                    /*if(img.getVisibility()!=View.VISIBLE)
                   {
                      img.setVisibility(View.VISIBLE);
                       img.animate()
                               .scaleX(1f)
                               .scaleY(1f)
                               .setStartDelay(100)
                               .setInterpolator(new FastOutSlowInInterpolator())
                               .setDuration(450)
                               .start();
                   }*/
                }
                else{
                    hideicon();
                    /*if(img.getVisibility()==View.VISIBLE)
                    { img.setScaleX(0f);
                        img.setScaleY(0f);
                       img.setVisibility(View.GONE);
                    }*/
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

               if(state==1)
                {
                    if(mxViewPager.getCurrentItem()==1 )
                    {
                        hideicon();
                    }
                    else{
                        animicon();
                    }
                }
                if(state==0 && mxViewPager.getCurrentItem()==1)
                {
                    animicon();
                }
            }
        });
    }


    private void animicon()
    {
        if(img.getVisibility()!=View.VISIBLE)
        {
            img.setVisibility(View.VISIBLE);
            img.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setStartDelay(100)
                    .setInterpolator(new FastOutSlowInInterpolator())
                    .setDuration(450)
                    .start();
        }
    }
    private void hideicon()
    {
        if(img.getVisibility()==View.VISIBLE)
        { img.setScaleX(0f);
            img.setScaleY(0f);
            img.setVisibility(View.GONE);
        }
    }
}
