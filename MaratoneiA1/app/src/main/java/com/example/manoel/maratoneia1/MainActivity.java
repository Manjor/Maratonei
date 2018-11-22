package com.example.manoel.maratoneia1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Movies.MovieFragment;
import com.example.manoel.maratoneia1.News.NewFragment;
import com.example.manoel.maratoneia1.Search.SeachActivity;
import com.example.manoel.maratoneia1.Series.SerieFragment;

public class MainActivity extends AppCompatActivity {
    
    //Atributes
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private NestedScrollView nestedScrollView;

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
            setSupportActionBar(toolbar);

            toolbar.setTitle("Maratonei");
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDarkRoxo));

            //Create a new instance of ViewPageAdapter
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

            viewPagerAdapter.addFragment(new MovieFragment(), getResources().getString(R.string.movies));
            viewPagerAdapter.addFragment(new SerieFragment(), getResources().getString(R.string.series));
            viewPagerAdapter.addFragment(new NewFragment(), getResources().getString(R.string.news));
            //viewPagerAdapter.addFragment(new MapFragment(), "Cinemas");

            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setTabMode(TabLayout.GRAVITY_CENTER);
            //tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_play_circle_outline_gray_24dp);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_tv_gray_24dp);
            tabLayout.getTabAt(2).setIcon(R.drawable.ic_forum_gray_24dp);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menuSearch){
            Intent it = new Intent(this,SeachActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
