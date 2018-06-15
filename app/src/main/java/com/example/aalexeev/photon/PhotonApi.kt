package com.example.aalexeev.photon.photonapi

import com.beust.klaxon.Klaxon
import com.example.aalexeev.photon.CardInfo
import com.example.aalexeev.photon.responseModels.PhotocardResponseModel
import com.github.kittinunf.fuel.httpGet
import java.nio.charset.Charset

object PhotonApi {
    var apiAddres = "http://207.154.248.163:5000"

    fun listAllPhotocardForCardInfo(limit: Int, offset: Int, sorted: Boolean, callBack: (photoCards: MutableList<CardInfo>) -> Unit) {
        val requestUrl =
            apiAddres + "/photocard/list?limit=" + limit.toString() + "&offset=" + offset.toString()
        val photocards = mutableListOf<CardInfo>()

        requestUrl.httpGet().response { request, response, result ->
            val dataList = Klaxon().parseArray<PhotocardResponseModel>(
                result.component1()!!.toString(
                    Charset.defaultCharset()
                )
            )
            dataList?.forEach {
                photocards.add(CardInfo(it.photo, it.favorits, it.views))
            }
            if (sorted) photocards.sortByDescending { it.countWatch }

            callBack(photocards)
        }
    }

    fun listAllPhotocard(limit: Int, offset: Int, callBack: (photoCards: List<PhotocardResponseModel>) -> Unit) {
        val requestUrl =
            apiAddres + "/photocard/list?limit=" + limit.toString() + "&offset=" + offset.toString()

        requestUrl.httpGet().response { request, response, result ->
            val dataList = Klaxon().parseArray<PhotocardResponseModel>(
                result.component1()!!.toString(
                    Charset.defaultCharset()
                )
            )
            callBack(dataList!!)
        }
    }
}