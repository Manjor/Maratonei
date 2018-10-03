package com.example.manoel.maratoneia1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.example.manoel.maratoneia1.Movies.MovieFragment;
import com.example.manoel.maratoneia1.News.NewsFragment;
import com.example.manoel.maratoneia1.Series.SerieFragment;

public class MainActivity extends AppCompatActivity {


    //Atributes
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Instance of with set ids
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutMain);
        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);

        //Create a new instance of ViewPageAdapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new MovieFragment(),getResources().getString(R.string.movies));
        viewPagerAdapter.addFragment(new SerieFragment(),getResources().getString(R.string.series));
        viewPagerAdapter.addFragment(new SerieFragment(), getResources().getString(R.string.news));


        Log.i("INFO","" + Configuracao.urlApi);
        Log.i("INFO","" + Configuracao.apiKey);
        Log.i("INFO","" + Configuracao.urlImageApi);
        Log.i("INFO","" + Configuracao.urlVideoApi);
        Log.i("INFO","" + getResources().getString(R.string.language).toString());

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}
