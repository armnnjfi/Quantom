package com.example.quantom.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.CategoryAdapter
import com.example.quantom.Entity.CategoryItem
import com.example.quantom.R


class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val items = listOf(
            CategoryItem(0,R.drawable.baseline_article_24, "مقالات"),
            CategoryItem(1 , R.drawable.baseline_mic_24 , " پادکست"),
            CategoryItem(3,R.drawable.baseline_image_24, "عکس و پوستر"),
            CategoryItem(4,R.drawable.baseline_video_library_24, "فیلم")
        )

        recyclerView.layoutManager = GridLayoutManager(context, 2)  // 2 ستون
        recyclerView.adapter = CategoryAdapter(items)
        var toolbar1: Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.category_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.queryHint = "Search..."

        // Optional: Customize the search view's appearance (e.g., background)
        val searchPlate = searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)
        searchPlate.setBackgroundColor(Color.parseColor("#D9D9D9")) // Set transparent background to avoid default underline

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search query submission
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle text changes in the search view
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Handle action settings click
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
