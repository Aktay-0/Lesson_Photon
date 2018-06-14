package com.example.aalexeev.photon

import android.app.Fragment
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beust.klaxon.JsonArray
import com.beust.klaxon.Klaxon
import com.example.aalexeev.photon.R.layout
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.fragment_home.*
import java.nio.charset.Charset

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater!!.inflate(layout.fragment_home, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home_toolbar.inflateMenu(R.menu.menu_home_toolbar)
        val photocards = mutableListOf<CardInfo>()

        "http://207.154.248.163:5000/photocard/list?limit=10&offset=0".httpGet().response { request, response, result ->
            val dataList = Klaxon().parseArray<ResponseModel>(result.component1()!!.toString(Charset.defaultCharset()))
            dataList?.forEach {
                photocards.add(CardInfo(Uri.parse(it.photo), it.favorits, it.views))
            }
            photocardList.layoutManager = GridLayoutManager(activity, 2)
            photocardList.adapter = HomeImageListAdapter(photocards)
        }
    }
}

data class ResponseModel(val owner: String, val title: String, val photo: String,
                         val active: Boolean, val updated: String, val created: String,
                         val views: Int, val favorits: Int, val filters: Filters,
                         val tags: List<String>, val id: String)

data class Filters(val lightDirection: String, val nuances: String, val decor: String,
                   val dish: String, val light: String, val temperature: String)