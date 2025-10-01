package com.example.editorperfil

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.editorperfil.Keys

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objKeys = Keys()
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

            val continuar = Intent(this, ResumenActivity::class.java)
            continuar.putExtra(objKeys.keyName,nombre)
            continuar.putExtra(objKeys.keyEdad,edad)
            continuar.putExtra(objKeys.keyCiudad,ciudad)
            continuar.putExtra(objKeys.keyCorreo, correo)
            startActivity(continuar)

        }
    }
}

