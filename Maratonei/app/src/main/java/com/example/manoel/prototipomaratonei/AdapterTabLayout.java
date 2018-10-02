package com.example.manoel.prototipomaratonei;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


//Classe adapter que irá implementar os tabItens da pagina Principal
public class AdapterTabLayout extends FragmentStatePagerAdapter {


    //Atributes of class

    //Instance of two arrays, to fragments and titles
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public AdapterTabLayout(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    //Method que irá implementar os titulos das abas
    public CharSequence getPageTitle(int position) {
        return this.titles.get(position);
    }

    //This is method will add the fragments and titles for using in ViewPager
    public void addFragments(Fragment fragment, String titles)
    {
        this.fragments.add(fragment);
        this.titles.add(titles);
    }




}
