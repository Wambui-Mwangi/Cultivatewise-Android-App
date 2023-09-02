package com.mwangi.cultivatewise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mwangi.cultivatewise.databinding.ActivityHomeBinding
import com.mwangi.cultivatewise.viewmodel.CropsViewModel

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    val cropsViewModel: CropsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {

        super.onResume()
        cropsViewModel.fetchCrops()
        cropsViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext, "err", Toast.LENGTH_LONG).show()
        })

        cropsViewModel.cropsLiveData.observe(this, Observer { cropsList->
            binding.rvCrops.layoutManager = LinearLayoutManager(this)
            binding.rvCrops.adapter= Adapter(cropsList, this)
         })
    }
}