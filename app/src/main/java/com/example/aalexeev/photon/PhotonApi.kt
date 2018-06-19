package com.example.aalexeev.photon.photonapi

import com.beust.klaxon.Klaxon
import com.example.aalexeev.photon.responseModels.PhotocardResponseModel
import com.example.aalexeev.photon.responseModels.UserInfoResponseModel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpHead
import java.nio.charset.Charset

object PhotonApi {
    var apiAddres = "http://207.154.248.163:5000"


    fun listAllPhotocard(limit: Int, offset: Int, callBack: (photoCards: List<PhotocardResponseModel>) -> Unit) {
        val requestUrl = "$apiAddres/photocard/list?limit=$limit&offset=$offset"

        requestUrl.httpGet().response { request, response, result ->
            val dataList = Klaxon().parseArray<PhotocardResponseModel>(
                result.component1()!!.toString(
                    Charset.defaultCharset()
                )
            )
            callBack(dataList!!)
        }
    }

    fun getPhotocard(userId: String, photocardId: String, callBack: (photoCard: PhotocardResponseModel) -> Unit) {
        val requestUrl = "$apiAddres/user/$userId/photocard/$photocardId"

        requestUrl.httpGet().response() { request, response, result ->
            val data =
                Klaxon().parse<PhotocardResponseModel>(
                    result.component1()!!.toString(
                        Charset.defaultCharset()
                    )
                )
            callBack(data!!)
        }
    }

    fun getUserInfo(userId: String, callBack: (userInfo: UserInfoResponseModel) -> Unit) {
        val requestUrl = "$apiAddres/user/$userId"

        requestUrl.httpGet().response() { request, response, result ->
            val data =
                Klaxon().parse<UserInfoResponseModel>(
                    result.component1()!!.toString(
                        Charset.defaultCharset()
                    )
                )
            callBack(data!!)
        }
    }
}