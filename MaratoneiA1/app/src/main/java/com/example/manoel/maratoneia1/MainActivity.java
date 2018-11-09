package com.example.manoel.maratoneia1;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Maps.MapFragment;
import com.example.manoel.maratoneia1.Movies.MovieFragment;
import com.example.manoel.maratoneia1.News.NewFragment;
import com.example.manoel.maratoneia1.Series.SerieFragment;

public class MainActivity extends AppCompatActivity {
    
    //Atributes
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    ConstraintLayout constraintLayout = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        verificaConexao();
//        if (verificaConexao()) {
            //Instance of with set ids
            toolbar = findViewById(R.id.toolbar);
            tabLayout = (TabLayout) findViewById(R.id.tabs);
            viewPager = (ViewPager) findViewById(R.id.pagerViewer);
            constraintLayout = (ConstraintLayout) findViewById(R.id.bottom_sheet);

            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(constraintLayout);
            bottomSheetBehavior.setPeekHeight(0);
            bottomSheetBehavior.setHideable(true);
            bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View view, int i) {

                }

                @Override
                public void onSlide(@NonNull View view, float v) {

                }
            });

            setSupportActionBar(toolbar);

            toolbar.setTitle("Maratonei");
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDarkRoxo));

            //Create a new instance of ViewPageAdapter
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

            viewPagerAdapter.addFragment(new MovieFragment(), getResources().getString(R.string.movies));
            viewPagerAdapter.addFragment(new SerieFragment(), getResources().getString(R.string.series));
            viewPagerAdapter.addFragment(new NewFragment(), getResources().getString(R.string.news));
            viewPagerAdapter.addFragment(new MapFragment(), "Cinemas");

            viewPager.setAdapter(viewPagerAdapter);

            tabLayout.setupWithViewPager(viewPager);
//        } else {
//
//            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//
//            dialog.setTitle(getResources().getString(R.string.errorconnection));
//            dialog.setMessage(getResources().getString(R.string.messageerrorconnection));
//
//            dialog.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    System.exit(1);
//                }
//            });
//
//            dialog.show();
//        }
    }
    public static boolean Connection = false;
    public boolean verificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        this.Connection = conectado;
        return conectado;
    }

}
