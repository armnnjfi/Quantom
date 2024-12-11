package com.example.quantom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.quantom.fragments.CategoryFragment
import com.example.quantom.fragments.HomeFragment
import com.example.quantom.fragments.ProfileFragment
import com.example.quantom.fragments.TaskFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val bottomAppBar: BottomAppBar = findViewById(R.id.bottom_app_bar)
    val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottomAppBar)




        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.action_search -> {
                    replaceFragment(CategoryFragment())
                    true
                }

                R.id.action_notifications -> {
                    replaceFragment(TaskFragment())
                    true
                }

                R.id.action_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()
    }



}