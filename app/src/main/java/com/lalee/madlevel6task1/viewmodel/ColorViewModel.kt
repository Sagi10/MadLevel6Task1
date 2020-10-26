package com.lalee.madlevel6task1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lalee.madlevel6task1.model.ColorItem
import com.lalee.madlevel6task1.repository.ColorRepository

class ColorViewModel(application: Application) : AndroidViewModel(application) {

    private val colorRepository = ColorRepository()

    //use encapsulation to expose as LiveData
    val colorItems: LiveData<List<ColorItem>>
      get() = _colorItems

    private val _colorItems = MutableLiveData<List<ColorItem>>().apply {
        value = colorRepository.getColorItems()
    }
}