package com.example.roomdamo2.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdamo2.R
import com.example.roomdamo2.databinding.FragmentListaCiudadBinding
import com.example.roomdamo2.presentation.view.adapter.CiudadAdapter
import com.example.roomdamo2.presentation.viewmodel.CiudadViewModel


class ListaCiudad : Fragment() {
    private lateinit var fbinding: FragmentListaCiudadBinding
    private lateinit var ciudadViewModel: CiudadViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentListaCiudadBinding.inflate(layoutInflater)
        fbinding.fabtnAgregarCiudad.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.acListaCiudad_AgregarCiudad)
        }
        loadRV()
        return fbinding.root
    }

    private fun loadRV() {
        val recycler = fbinding.rvCiudad
        val adapter = CiudadAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        recycler.adapter = adapter

        ciudadViewModel = ViewModelProvider(this).get(CiudadViewModel::class.java)

        ciudadViewModel.ciudades.observe(viewLifecycleOwner, Observer {ciudad ->
            adapter.setCiudad(ciudad)
        })

    }

}