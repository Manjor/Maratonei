package com.example.manoel.prototipomaratonei;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.manoel.prototipomaratonei.FragmentsMain.FavoritesFragment;
import com.example.manoel.prototipomaratonei.FragmentsMain.MoviesFragment;
import com.example.manoel.prototipomaratonei.FragmentsMain.SeriesFragment;

public class PrincipalActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tabLayout = findViewById(R.id.tabLayoutPrincipal);
        viewPager = findViewById(R.id.viewPagePrincipal);

        AdapterTabLayout adapterTabLayout = new AdapterTabLayout(getSupportFragmentManager());
        adapterTabLayout.addFragments(new SeriesFragment(),"Series");
        adapterTabLayout.addFragments(new MoviesFragment(),"Movies");
        adapterTabLayout.addFragments(new FavoritesFragment(),"Favorites");

        viewPager.setAdapter(adapterTabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }
}
