package com.example.manoel.maratoneia1;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    //Atributes
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentListTitles = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }


    //Override methods of the class FragmentPagerAdapter
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    //Override the titles of fragments
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }

    @Override
    public int getCount() {
        return 0;
    }


    //Method that create a new tabItem with a fragment
    public void addFragment(Fragment fragment, String title){
        //Add fragment and titles of tabItems
        fragmentList.add(fragment);
        fragmentListTitles.add(title);

    }
}
