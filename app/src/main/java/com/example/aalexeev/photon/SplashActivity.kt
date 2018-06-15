package com.example.aalexeev.photon

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.aalexeev.photon.photonapi.PhotonApi
import com.example.aalexeev.photon.realmModels.PhotocardModel
import io.realm.Realm

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Realm.init(this)
        val realm = Realm.getDefaultInstance()

        PhotonApi.listAllPhotocard(10, 0) {
            realm.beginTransaction()
            it.forEach {
                realm.insertOrUpdate(it.toPhotocardModel())
            }
            realm.commitTransaction()
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}