package com.example.materialtest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar




class MainActivity : AppCompatActivity() {

val fruits=mutableListOf(Fruit("Apple", R.drawable.apple), Fruit("Banana",
    R.drawable.banana), Fruit("Orange", R.drawable.orange), Fruit("Watermelon",
    R.drawable.watermelon), Fruit("Pear", R.drawable.pear), Fruit("Grape",
    R.drawable.grape), Fruit("Pineapple", R.drawable.pineapple), Fruit("Strawberry",
    R.drawable.strawberry), Fruit("Cherry", R.drawable.cherry), Fruit("Mango",
    R.drawable.mango))

   val fruitList= ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val toolbar=findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout=findViewById<DrawerLayout>(R.id.drawerlayout)
        toolbar.setNavigationIcon(R.drawable.ic_menu)

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        val fab=findViewById<FloatingActionButton>(R.id.fab)
        //setSupportActionBar(toolbar)
        fab.setOnClickListener {view ->
            Snackbar.make(view,"Data deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo"){
                    Toast.makeText(this,"Data restored",Toast.LENGTH_SHORT).show()
                }
                .show()

        }


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
        initFruits()
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)

        val layoutManager= GridLayoutManager(this,2)
        recyclerView.layoutManager=layoutManager
        val adapter= FruitAdapter(this,fruitList)
        recyclerView.adapter=adapter

    }

    private fun initFruits(){
        fruitList.clear()
        repeat(50){
            val index=(0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

}