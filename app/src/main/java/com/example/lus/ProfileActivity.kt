package com.example.lus

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lus.databinding.ActivityProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation()
    }

    private fun navigation() {

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val controller = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.newsFragment,
            R.id.settingsFragment
        ))

        setupActionBarWithNavController(controller, appBarConfiguration)
        bottomNavigationView.setupWithNavController(controller)

    }
}