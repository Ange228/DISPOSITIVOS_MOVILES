package com.example.fragmetsnavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class SelecComidaFragment : Fragment(R.layout.fragment_select_comida) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<Button>(R.id.btnSiguienteOpcion)
        val rgComida = view.findViewById<RadioGroup>(R.id.radioGroupComida)//obtenemos el valor del xml

        // volver Resumen y editar la comida
        setFragmentResultListener("editarPedido") { key, bundle ->
            val comidaEdit = bundle.getString(Keys().dulce) ?: " "

            when (comidaEdit) {
                "Cupcacke" -> rgComida.check(R.id.rbCupcacke)
                "Brownie" -> rgComida.check(R.id.rbBrownie)
                "Trufa" -> rgComida.check(R.id.rbTrufa)
            }
        }


        btnNext.setOnClickListener {

            val dulceSelec = when(rgComida.checkedRadioButtonId){
                R.id.rbCupcacke -> "Cupcacke"
                R.id.rbBrownie -> "Brownie"
                R.id.rbTrufa -> "Trufa"
                else -> "sin dulcito"
            }

            val datosDulce = bundleOf(Keys().dulce to dulceSelec)
            findNavController().navigate(R.id.action_selectComidaFragment_to_selectExtrasFragment, datosDulce)



        }

    }

}
