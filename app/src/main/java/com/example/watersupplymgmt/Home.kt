package com.example.watersupplymgmt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.watersupplymgmt.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}