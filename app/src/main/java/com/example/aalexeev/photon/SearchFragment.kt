package com.example.aalexeev.photon

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater!!, container, savedInstanceState)
        return inflater!!.inflate(R.layout.fragment_search, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SearchFragmentViewPagerAdapter(fragmentManager)

        adapter.addFragment(SimpleSearchFragment(), "ПОИСК")
        adapter.addFragment(SearchFiltersFragment(), "ФИЛЬТРЫ")

        searchViewPager.adapter = adapter
        searchTabs.setupWithViewPager(searchViewPager)
    }
}