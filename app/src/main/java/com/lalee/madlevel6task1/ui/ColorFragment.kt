package com.lalee.madlevel6task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lalee.madlevel6task1.R
import com.lalee.madlevel6task1.adapter.ColorAdapter
import com.lalee.madlevel6task1.model.ColorItem
import kotlinx.android.synthetic.main.fragment_color.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ColorFragment : Fragment() {

    private val colors = arrayListOf<ColorItem>()
    lateinit var colorAdapter: ColorAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        colorAdapter = ColorAdapter(colors, ::onColorClick)
        super.onViewCreated(view, savedInstanceState)
        rv_colors.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_colors.adapter = colorAdapter

        observeColors()
    }

    private fun observeColors() {
        TODO("Not yet implemented")
    }

    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(rv_colors, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG).show()
    }

}