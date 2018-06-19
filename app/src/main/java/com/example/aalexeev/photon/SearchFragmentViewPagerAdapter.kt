package com.example.aalexeev.photon

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter

class SearchFragmentViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var fragments = mutableListOf<Fragment>()
    private var fragmentsTitles = mutableListOf<String>()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = fragmentsTitles[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentsTitles.add(title)
    }
}