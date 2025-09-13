package com.example.reproductos_de_musica

import android.os.Bundle
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MusicActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var tvStatus: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music2)

        // Enlazamos componentes de la vista en este apartado

        tvStatus = findViewById(R.id.tvStatus)
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)

        // Inicializamos MediaPlayer con el archivo en res/raw/
        mediaPlayer = MediaPlayer.create(this, R.raw.cancion_trabajo) //

        // Este apartado es para el botón de reproduccion de musiquita
        btnPlay.setOnClickListener {
            mediaPlayer?.start()
            tvStatus.text = "Reproduciendo tu musiquita"
        }

        // En este apartado se incluye el botón pausa
        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                tvStatus.text = "Pausaste tu musiquita"
            }
        }

        // En este apartado se incluye el botón de stop
        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            tvStatus.text = "Stop"
            mediaPlayer = MediaPlayer.create(this, R.raw.cancion_trabajo)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
