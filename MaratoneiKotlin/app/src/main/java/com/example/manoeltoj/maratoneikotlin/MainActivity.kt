package com.example.manoeltoj.maratoneikotlin

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.Toolbar
import android.telecom.Connection
import android.widget.TableLayout


class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var toolbar: Toolbar
    lateinit var nestedScrollView: NestedScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        verifyConnection()

        toolbar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.pagerViewer)
        setSupportActionBar(toolbar)

        toolbar.setTitle("Maratonei")
        toolbar.setTitleTextColor(resources.getColor(R.color.colorPrimaryDarkRoxo))

        var viewPagerAdapter:ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
//        viewPagerAdapter.addFragment()
//        viewPagerAdapter.addFragment()
//        viewPagerAdapter.addFragment()

        viewPager.setAdapter(viewPagerAdapter)
        tabLayout.setupWithViewPager(viewPager)


    }

    companion object {
        var CONNECTION:Boolean = false
    }
    fun verifyConnection(): Boolean {
        var connected: Boolean;
        var conectivityManager: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (
                conectivityManager.getActiveNetworkInfo() != null && conectivityManager.activeNetworkInfo.isConnected()
        ) {
            connected = true
        } else {
            connected = false
        }
        CONNECTION = connected
        return connected;
    }
}
