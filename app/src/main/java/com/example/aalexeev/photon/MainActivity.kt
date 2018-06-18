package com.example.aalexeev.photon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val ft = fragmentManager.beginTransaction()
        val fragment = HomeFragment()
        ft.replace(R.id.mainViewPort, fragment)
        ft.commit()

        bottom_navigation_bar.setOnNavigationItemSelectedListener {
            val ft = fragmentManager.beginTransaction()

            val fragment  = when(it.itemId) {
                R.id.action_home -> HomeFragment()
                R.id.action_profile -> ProfileFragment()
                R.id.action_load-> LoadFragment()
                else -> HomeFragment()
            }

            ft.replace(R.id.mainViewPort, fragment)
            ft.commit()

            true
        }
    }
}
