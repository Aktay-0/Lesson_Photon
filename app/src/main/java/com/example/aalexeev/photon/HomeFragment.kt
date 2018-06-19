package com.example.aalexeev.photon

import android.annotation.TargetApi
import android.app.Fragment
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aalexeev.photon.R.layout
import com.example.aalexeev.photon.realmModels.PhotocardModel
import io.realm.Realm
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

    @TargetApi(VERSION_CODES.M)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home_toolbar.inflateMenu(R.menu.menu_home_toolbar)
        photocardList.adapter = HomeImageListAdapter(listOf(CardInfo()), fragmentManager)
        photocardList.layoutManager = GridLayoutManager(context, 2)

        Realm.init(context)
        val realm = Realm.getDefaultInstance()

        val dataList = realm.where(PhotocardModel::class.java).findAll()
        val cards = mutableListOf<CardInfo>()

        dataList.forEach {
            cards.add(CardInfo(it.id, it.owner, it.photo, it.favorits, it.views))
        }

        photocardList.adapter = HomeImageListAdapter(cards, fragmentManager)

        home_toolbar.setOnMenuItemClickListener {
            val ft = fragmentManager.beginTransaction()

            val fragment = when (it.itemId) {
                R.id.toolbarSearch -> SearchFragment()
                else -> return@setOnMenuItemClickListener true
            }

            ft.replace(R.id.mainViewPort, fragment)
            ft.commit()
            true
        }
    }
}