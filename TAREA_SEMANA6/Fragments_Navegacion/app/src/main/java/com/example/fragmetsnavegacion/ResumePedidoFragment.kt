package com.example.fragmetsnavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

class ResumenPedidoFragment : Fragment(R.layout.fragment_resume_pedido) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnConfirm = view.findViewById<Button>(R.id.btnEditar)
        val btnEdit = view.findViewById<Button>(R.id.btnConfirmar)
        val txtPedido = view.findViewById<TextView>(R.id.txtDulceFinal)

        val dulce = arguments?.getString(Keys().dulce) ?: "sin dulcito"
        val extradulce = arguments?.getString(Keys().extradulce) ?: "sin extradulce"

        txtPedido.text = "Tu pedido completo: $dulce Extra $extradulce"
        btnConfirm.setOnClickListener {

            Toast.makeText(requireContext(), "PedidoConfirmado", Toast.LENGTH_LONG).show()
            findNavController().popBackStack(R.id.inicioFragment,false)

        }

        btnEdit.setOnClickListener {
            // Enviar resultado, SelecComidaFragment reciba la comida a editar
            val result = bundleOf(Keys().dulce to dulce)
            setFragmentResult("editarPedido", result)
            findNavController().popBackStack(R.id.action_resumePedidoFragment_to_inicioFragment, false)

        }

    }

}