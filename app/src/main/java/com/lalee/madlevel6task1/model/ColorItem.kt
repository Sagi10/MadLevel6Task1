package com.lalee.madlevel6task1.model

data class ColorItem(

    var name: String,
    var hex: String
) {
    fun getImageUrl() = ("https://singlecolorimage.com/get/$hex/1080x1080")
}