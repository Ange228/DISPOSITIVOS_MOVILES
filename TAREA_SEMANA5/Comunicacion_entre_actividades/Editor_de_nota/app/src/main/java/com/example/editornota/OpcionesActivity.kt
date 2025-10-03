package com.example.editornota

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class OpcionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val txtNota = findViewById<TextView>(R.id.txtNota)
        val btnCompartir = findViewById<Button>(R.id.btnCompartir)
        val btnEditar = findViewById<Button>(R.id.btnEditar)


        val nota = intent.getStringExtra("NOTA")
        txtNota.text = "¡Esta es la nota que esribiste! \n \n Tu mensaje es: $nota"

        val notaRest = savedInstanceState?.getString("Nota")
        if (notaRest != null) txtNota.setText(notaRest)

        btnEditar.setOnClickListener {
            val nota = Intent()
            finish()
        }

        btnCompartir.setOnClickListener {
            Toast.makeText(this,"Compartido por correo", Toast.LENGTH_LONG).show()
        }



        }
    }
