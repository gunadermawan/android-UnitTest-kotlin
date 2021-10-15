package com.gunder.myunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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
        viewModel = MainViewModel(CuboidModel())
        binding.btnSave.setOnClickListener(this)
        binding.btnCalculateSurfaceArea.setOnClickListener(this)
        binding.btnCalculateCircumference.setOnClickListener(this)
        binding.btnCalculateVolume.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val width = binding.edtWidth.text.toString().trim()
        val length = binding.edtLength.text.toString().trim()
        val height = binding.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                binding.edtLength.error = "belum di isi!"
            }
            TextUtils.isEmpty(width) -> {
                binding.edtWidth.error = "belum di isi!"
            }
            TextUtils.isEmpty(height) -> {
                binding.edtHeight.error = "belum di isi!"
            }
            else -> {
                val valueWidth = length.toDouble()
                val valueLength = width.toDouble()
                val valueHeight = height.toDouble()

                when (v?.id) {
                    R.id.btn_save -> {
                        viewModel.save(valueWidth, valueLength, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = viewModel.getCircumFerence().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = viewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        binding.tvResult.text = viewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun gone() {
        binding.btnCalculateVolume.visibility = View.GONE
        binding.btnCalculateCircumference.visibility =View.GONE
        binding.btnCalculateSurfaceArea.visibility = View.GONE
        binding.btnSave.visibility = View.VISIBLE
    }

    private fun visible() {
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        binding.btnSave.visibility = View.GONE
    }
}