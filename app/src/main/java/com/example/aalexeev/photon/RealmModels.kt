package com.example.aalexeev.photon.realmModels

import io.realm.RealmList
import io.realm.RealmObject

open class PhotocardModel() : RealmObject() {
    var owner: String = ""
    var title: String = ""
    var photo: String = ""
    var active: Boolean = false
    var updated: String = ""
    var created: String = ""
    var views: Int = 0
    var favorits: Int = 0
    var filters: FiltersModel? = null
    var tags: RealmList<String> = RealmList()
    var id: String = ""
}

open class FiltersModel() : RealmObject() {
    var lightDirection: String = ""
    var decor: String = ""
    var nuances: String = ""
    var dish: String = ""
    var light: String = ""
    var temperature: String = ""
}