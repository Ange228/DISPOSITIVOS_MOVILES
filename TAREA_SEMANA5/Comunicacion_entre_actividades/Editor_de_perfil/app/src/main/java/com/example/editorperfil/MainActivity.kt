package com.example.editorperfil

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.edtName)
        val editTextEdad= findViewById<EditText>(R.id.edtEdad)
        val editTextCiudad= findViewById<EditText>(R.id.edtCiudad)
        val editTextCorreo= findViewById<EditText>(R.id.edtCorreo)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)

        btnContinuar.setOnClickListener{
            val nombre = editTextName.text.toString()
            val edad = editTextEdad.text.toString().toInt()
            val ciudad = editTextCiudad.text.toString()
            val correo = editTextCorreo.text.toString()


        }
    }
}