package com.example.materialtest

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val toolbar=findViewById<Toolbar>(R.id.toolbar)
      // setSupportActionBar(toolbar)
        toolbar?.inflateMenu(R.menu.toolbar)
       toolbar?.setOnMenuItemClickListener {
           item ->
           when (item.itemId) {
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