package com.example.quantom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quantom.fragments.HomeFragment
import com.example.quantom.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        init()

    }


    private fun bindViews() {
        bottomNavigation = findViewById(R.id.bottomNavigationView)

    }

    fun init() {
        bindViews()
        bottomNavigation.setOnNavigationItemSelectedListener() { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content_frame, HomeFragment())
                    transaction.commit()
                    true
                }

                R.id.action_profile -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content_frame, ProfileFragment())
                    transaction.commit()
                    true
                }

                else -> false
            }
        }
        bottomNavigation.selectedItemId = R.id.action_home

    }


}
