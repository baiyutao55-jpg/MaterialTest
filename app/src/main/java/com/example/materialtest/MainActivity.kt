package com.example.materialtest

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

    }
}