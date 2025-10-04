package com.example.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.adapter.UsuarioAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private lateinit var adpUsuarios: UsuarioAdapter
    private lateinit var listaUsuarios: RecyclerView

    override fun onViewCreated(vista: View, savedInstanceState: Bundle?) {
        super.onViewCreated(vista, savedInstanceState)
        inicializarRecycler()
        inicializarBotonAgregar()
    }

    private fun inicializarBotonAgregar() {
        val botonAgregar = requireView().findViewById<FloatingActionButton>(R.id.btnAgregar)
        botonAgregar.setOnClickListener {
            val indice = adpUsuarios.itemCount
            val usuarioNuevo = Usuario("Usuario $indice", 20, "correo$indice@gmail.com", "1234")
            adpUsuarios.agregarPersona(usuarioNuevo) // <- CAMBIO: usar el nombre actual del método
            listaUsuarios.scrollToPosition(indice)
        }
    }

    private fun inicializarRecycler() {
        adpUsuarios = UsuarioAdapter(UsuarioProvider.instance.listaUsuario)
        listaUsuarios = requireView().findViewById(R.id.recyclerViewUsuarios)
        listaUsuarios.adapter = adpUsuarios
        listaUsuarios.layoutManager = LinearLayoutManager(requireContext())
        listaUsuarios.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }
}
