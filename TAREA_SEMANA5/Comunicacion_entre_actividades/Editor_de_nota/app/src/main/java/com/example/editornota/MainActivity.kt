package com.example.editornota

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNota = findViewById<EditText>(R.id.edtNota)
        val btnCompartir = findViewById<Button>(R.id.btnCompartir)

        btnCompartir.setOnClickListener {
            val nota = editTextNota.text.toString()

            val compartir = Intent(this, OpcionesActivity::class.java)
            compartir.putExtra("NOTA", nota)
            startActivity(compartir)
        }


        }
    }


