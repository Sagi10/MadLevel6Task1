package com.lalee.madlevel6task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lalee.madlevel6task1.R
import com.lalee.madlevel6task1.adapter.ColorAdapter
import com.lalee.madlevel6task1.model.ColorItem
import com.lalee.madlevel6task1.viewmodel.ColorViewModel
import kotlinx.android.synthetic.main.fragment_color.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ColorFragment : Fragment() {

    private val colors = arrayListOf<ColorItem>()
    lateinit var colorAdapter: ColorAdapter

    private val colorViewModel: ColorViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorAdapter = ColorAdapter(colors, ::onColorClick)
        rv_colors.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_colors.adapter = colorAdapter

        observeColors()
    }

    private fun observeColors() {
        colorViewModel.colorItems.observe(viewLifecycleOwner, Observer {
            colors.clear()
            colors.addAll(it)
            colorAdapter.notifyDataSetChanged()
        })
    }

    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(rv_colors, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG).show()
    }
}