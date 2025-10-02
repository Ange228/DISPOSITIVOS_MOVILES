package com.example.editorperfil

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.editorperfil.Keys
class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val objKeys = Keys()

        val txtResult = findViewById<TextView>(R.id.txtResult)
        val name = intent.getStringExtra(objKeys.keyName)
        val edad = intent.getIntExtra(objKeys.keyEdad,-1)
        val ciudad = intent.getStringExtra(objKeys.keyCiudad)
        val correo = intent.getStringExtra(objKeys.keyCorreo)

        txtResult.text = "¡Gracias por llenar tu información! \n \n Tus datos son \n Nombre: $name \n Edad: $edad \n Ciudad: $ciudad \n Correo: $correo"

        }
    }

