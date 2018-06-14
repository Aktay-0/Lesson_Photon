package com.example.aalexeev.photon

import android.net.Uri

data class CardInfo(val image: Uri = Uri.EMPTY, val countLike: Int = 0, val countWatch: Int = 0)