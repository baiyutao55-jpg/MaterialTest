package com.example.materialtest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val toolbar=findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout=findViewById<DrawerLayout>(R.id.drawerlayout)
        toolbar.setNavigationIcon(R.drawable.ic_menu)

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }

        //setSupportActionBar(toolbar)

        val navview=findViewById<NavigationView>(R.id.navView)
        navview.setCheckedItem(R.id.navCall)
        navview.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        /*
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)


        }*/


        toolbar?.inflateMenu(R.menu.toolbar)
       toolbar?.setOnMenuItemClickListener {
           item ->
           when (item.itemId) {
               android.R.id.home-> drawerLayout.openDrawer(GravityCompat.START)
               R.id.backup -> Toast.makeText(
                   toolbar.context,
                   "You clicked Backup",
                   Toast.LENGTH_SHORT
               ).show()

               R.id.delete -> Toast.makeText(
                   toolbar.context,
                   "You clicked Delete",
                   Toast.LENGTH_SHORT
               ).show()

               R.id.settings -> {
                   Log.d("Mactiy","Setting")
                   Toast.makeText(
                       toolbar.context,
                       "You clicked Settings",
                       Toast.LENGTH_SHORT
                   ).show()

               }
           }
           true
       }


    }



}