package com.example.fragmetsnavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class SelectExtrasFragment : Fragment(R.layout.fragment_select_extras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<Button>(R.id.btnSiguiente)
        val rgExtra = view.findViewById<RadioGroup>(R.id.radioGroupExtra)
        val txtProceso = view.findViewById<TextView>(R.id.txtSelExtra)

        val dulce = arguments?.getString(Keys().dulce) ?: ""// obtenemos el dulce del fragment comida
        txtProceso.text = "Tu selecion dulce es: $dulce"


        btnNext.setOnClickListener {

            val extraSelect = when(rgExtra.checkedRadioButtonId){
                R.id.rbCremaPastelera -> "Crema pastelera"
                R.id.rbFodge -> "Fodge"
                R.id.rbChispitas -> "Chispitas"
                else -> "sin extra dulce"
            }

            val datosDulces = bundleOf(Keys().dulce to dulce, Keys().extradulce to extraSelect)

            findNavController().navigate(R.id.action_selectExtrasFragment_to_resumePedidoFragment, datosDulces)
        }

    }
}