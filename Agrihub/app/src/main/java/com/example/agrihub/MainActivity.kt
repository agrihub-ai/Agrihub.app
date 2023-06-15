package com.example.agrihub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agrihub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val nitrogen = binding.n.text.toString()
            val phosphorus = binding.p.text.toString()
            val kallium = binding.k.text.toString()
            val resistivity = binding.resist.text.toString()
            val temperature = binding.temp.text.toString()
            val humidity = binding.humid.text.toString()

            val errorMessages = mutableListOf<String>()

            if (nitrogen.isEmpty()) {
                errorMessages.add("Masukkan Nilai untuk nitrogen")
            }
            if (phosphorus.isEmpty()) {
                errorMessages.add("Masukkan Nilai untuk phosphorus")
            }
            if (kallium.isEmpty()) {
                errorMessages.add("Masukkan Nilai untuk potassium")
            }
            if (resistivity.isEmpty()) {
                errorMessages.add("Masukkan Nilai untuk resistivity")
            }
            if (temperature.isEmpty()) {
                errorMessages.add("Masukkan Nilai untuk temperature")
            }
            if (humidity.isEmpty()) {
                errorMessages.add("Masukkan Nilai untuk humidity")
            }

            if (errorMessages.isNotEmpty()) {
                val errorMessage = errorMessages.joinToString("\n")
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            } else {
                val res =
                    "Kesehatan = $nitrogen\n\nUrea_Bulk = $phosphorus\n\nTSP_Bulk = $kallium\n\nKCL_Bulk = $resistivity\n\nUrea_Mat = $temperature\n\nTSP_Mat = $humidity"
                showLoading(true)
                showResult(res)
            }
        }
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

    private fun showResult(resultText: String) {
        val intent = Intent(this, result::class.java)
        intent.putExtra("RESULT_TEXT", resultText)
        startActivity(intent)
        binding.apply {
            n.clear()
            p.clear()
            k.clear()
            resist.clear()
            temp.clear()
            humid.clear()
        }
    }


    private fun EditText.clear() {
        text.clear()
    }
}
