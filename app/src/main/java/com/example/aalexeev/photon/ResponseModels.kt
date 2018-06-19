package com.example.aalexeev.photon.responseModels

import com.example.aalexeev.photon.realmModels.FiltersModel
import com.example.aalexeev.photon.realmModels.PhotocardModel

data class PhotocardResponseModel(val owner: String, val title: String, val photo: String,
                         val active: Boolean, val updated: String, val created: String,
                         val views: Int, val favorits: Int, val filters: FiltersResponseModel,
                         val tags: List<String>, val id: String) {
    fun toPhotocardModel(): PhotocardModel {
        val model = PhotocardModel()
        val modelFiltesr = FiltersModel()
        model.owner = owner
        model.title = title
        model.photo = photo
        model.active = active
        model.updated = updated
        model.created = created
        model.views = views
        model.favorits = favorits
        model.id = id

        modelFiltesr.lightDirection = filters.lightDirection
        modelFiltesr.nuances = filters.nuances
        modelFiltesr.decor = filters.decor
        modelFiltesr.dish = filters.dish
        modelFiltesr.light = filters.light
        modelFiltesr.temperature = filters.temperature
        model.filters = modelFiltesr

        tags.forEach {
            model.tags.add(it)
        }

        return model
    }

}

data class FiltersResponseModel(val lightDirection: String, val nuances: String, val decor: String,
                   val dish: String, val light: String, val temperature: String)

data class AlbumResponseModel(val id: String, val owner: String, val title: String, val preview: String,
                              val description: String, val views: Int, val favorits: Int, val photocards: List<PhotocardResponseModel>)

data class UserInfoResponseModel(val id: String, val name: String, val login: String, val avatar: String,
                             val albumCount: Int, val photoCardCount: Int, val albums: List<AlbumResponseModel>)