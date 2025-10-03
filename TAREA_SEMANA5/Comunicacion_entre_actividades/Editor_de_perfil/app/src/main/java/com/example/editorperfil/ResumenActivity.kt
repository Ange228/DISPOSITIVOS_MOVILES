package com.example.editorperfil

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.editorperfil.Keys
class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val objKeys = Keys()

        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        val name = intent.getStringExtra(objKeys.keyName)
        val edad = intent.getIntExtra(objKeys.keyEdad,-1)
        val ciudad = intent.getStringExtra(objKeys.keyCiudad)
        val correo = intent.getStringExtra(objKeys.keyCorreo)

        txtResult.text = "¡Gracias por llenar tu información! \n \n Tus datos son \n Nombre: $name \n Edad: $edad \n Ciudad: $ciudad \n Correo: $correo"


        btnEditar.setOnClickListener {
            finish()
        }


        btnConfirmar.setOnClickListener {
            //val continuar = Intent(this, MainActivity::class.java)
            //startActivity(continuar)
            val message = Intent()
            message.putExtra("RESULT", "¡Perfil guardado correctamente!")
            setResult(RESULT_OK, message)
            finish()

            }
        }
    }

