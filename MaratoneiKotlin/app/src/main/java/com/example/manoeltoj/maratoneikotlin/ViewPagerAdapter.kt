package com.example.manoeltoj.maratoneikotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    var fragmentList:ArrayList<Fragment> = ArrayList()
    var fragmentListTitles:ArrayList<String> = ArrayList()

    override fun getItem(p0: Int): Fragment {
        return fragmentList.get(p0)
    }

    override fun getCount(): Int {
        return fragmentListTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentListTitles.get(position)
    }

    fun addFragment(fragment: Fragment,title:String){
        this.fragmentList.add(fragment)
        this.fragmentListTitles.add(title)
    }
}