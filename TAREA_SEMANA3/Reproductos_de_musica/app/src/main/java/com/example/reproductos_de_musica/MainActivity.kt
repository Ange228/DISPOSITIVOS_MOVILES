/*
Descripción: Reproductor básico usando MediaPlayer con botones Reproducir, Pausar y Detener.
Autor: Angélica Tovar
Fecha creación: 2025-09-12
Fecha última modificación: 2025-09-12
*/

package com.example.reproductos_de_musica

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var isPaused: Boolean = false
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music2)

        tvStatus = findViewById(R.id.tvStatus)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        btnPlay.setOnClickListener {
            // Creamos instancia si aún no existe
            if (mediaPlayer == null) {

                mediaPlayer = MediaPlayer.create(this, R.raw.cancion_trabajo)
                if (mediaPlayer == null) {
                    Toast.makeText(this, "Error al cargar el audio.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                mediaPlayer?.setOnCompletionListener {
                    tvStatus.text = "Estado: detenido"
                    Toast.makeText(this, "Reproducción finalizada", Toast.LENGTH_SHORT).show()
                    it.release()
                    mediaPlayer = null
                    isPaused = false
                }
            }

            // Realizamos la lógica para Reanudar o iniciar
            if (isPaused) {
                mediaPlayer?.start()
                isPaused = false
            } else if (mediaPlayer?.isPlaying != true) {
                mediaPlayer?.start()
            }
            tvStatus.text = "Estado: reproduciendo"
        }

        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                isPaused = true
                tvStatus.text = "Estado: en pausa"
            } else {
                Toast.makeText(this, "No hay reproducción activa para pausar", Toast.LENGTH_SHORT).show()
            }
        }

        btnStop.setOnClickListener {
            mediaPlayer?.let {
                try {
                    if (it.isPlaying || isPaused) {
                        it.stop()
                    }
                } catch (e: IllegalStateException) {
                    // si ocurre por el estado, igual liberamos
                } finally {
                    it.release()
                    mediaPlayer = null
                    isPaused = false
                    tvStatus.text = "Estado: detenido"
                }
            } ?: run {
                Toast.makeText(this, "No hay reproducción activa", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        // Pausar la reproducción si la app va a background
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
            isPaused = true
            tvStatus.text = "Estado: en pausa"
        }
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}


