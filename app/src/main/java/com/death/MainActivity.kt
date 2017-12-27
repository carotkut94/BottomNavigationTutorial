package com.death

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import com.example.rajora_sd.bottonnaviagtionbartutorial.R


class MainActivity : AppCompatActivity() {

    private var toolbar : ActionBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar
        var bottomNavigationView = navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val params:CoordinatorLayout.LayoutParams = bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = BottomNavigationBehavior()
        toolbar?.title = "Shop"
        loadFragment(StoreFragment())
    }
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigation_shop -> {
                Log.e("Clicked", "Shop")
                loadFragment(StoreFragment())
            }
            R.id.navigation_cart -> {
                Log.e("Clicked", "Cart")
                loadFragment(CartFragment())
            }
            R.id.navigation_gifts -> {
                Log.e("Clicked", "Gift")
                loadFragment(GiftFragment())
            }
            R.id.navigation_profile -> {
                Log.e("Clicked", "Profile")
                loadFragment(ProfileFragment())
            }
        }
        return@OnNavigationItemSelectedListener true
    }


    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
