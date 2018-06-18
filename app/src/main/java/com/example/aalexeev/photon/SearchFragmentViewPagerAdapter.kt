package com.example.aalexeev.photon

import android.app.Fragment
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class SearchFragmentViewPagerAdapter() : PagerAdapter() {

    private var fragments = mutableListOf<Fragment>()
    private var fragmentsTitles = mutableListOf<String>()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return fragments[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        fragments.removeAt(position)
        fragmentsTitles.removeAt(position)
    }

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = fragmentsTitles[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentsTitles.add(title)
    }
}