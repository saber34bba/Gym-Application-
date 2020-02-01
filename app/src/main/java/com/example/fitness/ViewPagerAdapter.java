package com.example.fitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fr_list=new ArrayList<>();
    private final  List<String> fr_list_name=new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return  fr_list.get(position);

    }

    @Override
    public int getCount() {
        return fr_list_name.size();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return fr_list_name.get(position);

    }
    public void AddFr(Fragment mfr,String title)
    {
        fr_list.add(mfr);
        fr_list_name.add(title);
    }


}
