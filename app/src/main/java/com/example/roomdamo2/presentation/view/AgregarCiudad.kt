package com.example.roomdamo2.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.roomdamo2.R
import com.example.roomdamo2.data.model.Ciudad
import com.example.roomdamo2.databinding.FragmentAgregarCiudadBinding
import com.example.roomdamo2.presentation.viewmodel.CiudadViewModel


class AgregarCiudad : Fragment() {

    private lateinit var fbinding: FragmentAgregarCiudadBinding
    private lateinit var ciudadViewModel: CiudadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentAgregarCiudadBinding.inflate(layoutInflater)
        ciudadViewModel = ViewModelProvider(this).get(CiudadViewModel::class.java)
        fbinding.btnAgregar.setOnClickListener {
            agregarCiudad()
            Navigation.findNavController(fbinding.root).navigate(R.id.acAgregarCiudad_ListaCiudad)
        }
        return fbinding.root
    }

    private fun agregarCiudad() {
        val nombre = fbinding.etNombreCiduad.text.toString()
        val poblacion = fbinding.etPoblacion.text.toString().toInt()
        val ciudad = Ciudad(0, nombre, poblacion)

        ciudadViewModel.addCiudad(ciudad)
    }

}