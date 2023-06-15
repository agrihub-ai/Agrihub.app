package com.example.agrihub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agrihub.databinding.ResultBinding

class result : AppCompatActivity() {

        private lateinit var binding: ResultBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ResultBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val rekomendasi = binding.hasil

            val resultText = intent.getStringExtra("RESULT_TEXT")
            rekomendasi.text = resultText
            showLoading(false)
        }
    private fun showLoading(isLoading: Boolean) {
        binding.apply {
            if (isLoading) {
                pb.animateVisibility(true)
            } else {
                pb.animateVisibility(false)
            }
        }
    }

    }