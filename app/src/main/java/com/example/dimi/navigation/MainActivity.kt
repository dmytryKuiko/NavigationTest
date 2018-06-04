package com.example.dimi.navigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navHostFragment: NavHostFragment?
        get() = supportFragmentManager.findFragmentById(R.id.navHostFragment) as? NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar?.let {
            it.inflateMenu(R.menu.toolbar_navigation)
            setSupportActionBar(it)
        }

        safeLet(bottomNavigationView, navHostFragment) { bottomNav, navHost ->
            NavigationUI.setupWithNavController(bottomNav, navHost.navController)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
        menuInflater.inflate(R.menu.toolbar_navigation, menu).run {
            true
        }


    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        NavigationUI.onNavDestinationSelected(
            item,
            Navigation.findNavController(this, R.id.navHostFragment)
        ) || super.onOptionsItemSelected(item)


    override fun onSupportNavigateUp(): Boolean =
        Navigation.findNavController(this, R.id.navHostFragment).navigateUp()

}

fun <T1 : Any, T2 : Any, R : Any> safeLet(t1: T1?, t2: T2?, block: (T1, T2) -> R?): R? =
    if (t1 != null && t2 != null) block(t1, t2) else null

