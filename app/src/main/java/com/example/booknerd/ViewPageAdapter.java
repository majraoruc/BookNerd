package com.example.booknerd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {
private List<Fragment> FragmentList=new ArrayList<>();
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior){
        super(fm,behavior);
    }
    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }
    public void addFragment(Fragment fragment){
        FragmentList.add(fragment);
    }
}
