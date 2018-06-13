package com.example.aalexeev.photon

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aalexeev.photon.R.layout
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater!!.inflate(layout.fragment_home, null)
    }
}