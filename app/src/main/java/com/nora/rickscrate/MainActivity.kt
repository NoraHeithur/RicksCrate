package com.nora.rickscrate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.nora.rickscrate.databinding.ActivityMainBinding
import com.nora.rickscrate.ui.extension.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null

    private fun setupBottomNavigationBarWithNavController() {
        val bottomNavigationView = binding.bottomNavMain
        val navGraphIds = listOf(
            R.navigation.nav_graph_character,
            R.navigation.nav_graph_episode,
            R.navigation.nav_graph_location
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_fragment_main,
            intent = intent
        )

        currentNavController = controller
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setupBottomNavigationBarWithNavController()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBarWithNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onBackPressed() {
        if (currentNavController?.value?.popBackStack() != true) {
            super.onBackPressed()
        }
    }
}