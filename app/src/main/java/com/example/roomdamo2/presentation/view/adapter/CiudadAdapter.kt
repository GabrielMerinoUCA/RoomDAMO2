package com.example.roomdamo2.presentation.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdamo2.R
import com.example.roomdamo2.data.model.Ciudad

class CiudadAdapter: RecyclerView.Adapter<CiudadAdapter.CiudadViewHolder>() {
    private var ciudadLista = emptyList<Ciudad>()
    inner class CiudadViewHolder(origin: View): RecyclerView.ViewHolder(origin){
        private val nombreCiudad = origin.findViewById<TextView>(R.id.tvNombreCiudad)
        private val poblacion = origin.findViewById<TextView>(R.id.tvPoblacion)
        private val counter = origin.findViewById<TextView>(R.id.tvCounter)

        @SuppressLint("SetTextI18n")
        fun load(ciudad: Ciudad, counter: Int){
            nombreCiudad.text = nombreCiudad.text.toString() + ciudad.nombre
            poblacion.text = poblacion.text.toString() + ciudad.poblacion.toString()
            this.counter.text = "${counter + 1}"
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCiudad(ciudadLista: List<Ciudad>){
        this.ciudadLista = ciudadLista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CiudadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CiudadViewHolder(layoutInflater.inflate(R.layout.rv_ciudad, parent, false))
    }

    override fun getItemCount() = ciudadLista.size

    override fun onBindViewHolder(holder: CiudadViewHolder, position: Int) {
        val ciudad = ciudadLista[position]
        holder.load(ciudad, position)
    }
}