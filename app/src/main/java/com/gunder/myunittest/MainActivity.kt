package com.gunder.myunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gunder.myunittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //    binding
    private lateinit var binding: ActivityMainBinding

    //    viewModel
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        btnListener
        viewModel = MainViewModel(CuboidModel())\
        binding.btnSave.setOnClickListener(this)
        binding.btnCalculateSurfaceArea.setOnClickListener(this)
        binding.btnCalculateCircumference.setOnClickListener(this)
        binding.btnCalculateVolume.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

    }
}