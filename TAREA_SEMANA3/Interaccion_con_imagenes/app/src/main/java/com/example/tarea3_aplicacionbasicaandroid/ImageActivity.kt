/*
Descripción: Al hacer clic en la imagen se muestra un Toast con un mensaje personalizado.
Autor: Angélica Tovar
Fecha creación: 2025-09-10
Fecha última modificación: 2025-09-12
*/



package com.example.tarea3_aplicacionbasicaandroid

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            Toast.makeText(
                this,
                "¡Le diste click al algodón! Ahora tendrás un día dulcito.",
                Toast.LENGTH_SHORT).show()
        }
    }
}
