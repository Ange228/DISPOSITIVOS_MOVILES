package com.example.ciclodevidaapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Este contador va a ir aumentando cada vez que presionemos el botón
    private var contador = 0

    // Referencia al TextView donde vamos a mostrar el contador
    private lateinit var textViewContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Conectamos esta Activity con su layout XML
        setContentView(R.layout.activity_main)

        // Buscamos el TextView en el layout para poder actualizarlo
        textViewContador = findViewById(R.id.textViewContador)
        // Buscamos el botón para poder detectar cuando lo presionen
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        // Cada vez que se presione el botón, aumentamos el contador y actualizamos el TextView
        btnAumentar.setOnClickListener {
            contador++
            textViewContador.text = "Contador: $contador"
        }

        // Para ver en consola que onCreate() se llamó
        Log.d("CICLO", "onCreate llamado")
        // Y también mostramos un pequeño mensaje en pantalla
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }

    // onStart() se llama justo antes de que la Activity se vuelva visible
    override fun onStart() {
        super.onStart()
        Log.d("CICLO", "onStart llamado")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    // onResume() se llama cuando la Activity ya está lista para interactuar con el usuario
    override fun onResume() {
        super.onResume()
        Log.d("CICLO", "onResume llamado")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    // onPause() se llama cuando la Activity deja de estar en primer plano
    override fun onPause() {
        super.onPause()
        Log.d("CICLO", "onPause llamado")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    // onStop() se llama cuando la Activity ya no es visible
    override fun onStop() {
        super.onStop()
        Log.d("CICLO", "onStop llamado")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    // onDestroy() se llama justo antes de que la Activity se destruya
    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLO", "onDestroy llamado")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }

    // Guardamos el estado actual de la Activity antes de que la destruyan (por ejemplo, al rotar)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CONTADOR", contador) // Guardamos el valor del contador
    }

    // Recuperamos el estado que guardamos antes, para que el contador no se pierda
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("CONTADOR") // Traemos el contador
        textViewContador.text = "Contador: $contador"   // Actualizamos la pantalla
    }
}
