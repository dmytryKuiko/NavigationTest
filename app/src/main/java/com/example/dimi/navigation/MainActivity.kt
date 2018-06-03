package com.example.dimi.navigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

        safeLet(bottomNavigationView, navHostFragment) { bottomNav, navHost ->
            NavigationUI.setupWithNavController(bottomNav, navHost.navController)
        }
    }
}

fun <T1 : Any, T2 : Any, R : Any> safeLet(t1: T1?, t2: T2?, block: (T1, T2) -> R?): R? =
    if (t1 != null && t2 != null) block(t1, t2) else null

