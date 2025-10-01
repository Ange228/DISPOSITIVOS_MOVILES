package com.example.editorperfil

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtName = findViewById<EditText>(R.id.edtName)
        val txtEdad = findViewById<EditText>(R.id.edtEdad)
        val txtCiudad = findViewById<EditText>(R.id.edtCiudad)
        val txtCorreo= findViewById<EditText>(R.id.edtCorreo)
        val txtName = findViewById<EditText>(R.id.edtName)

    }
}