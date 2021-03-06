package com.example.botcamp_kotlin_dio_cartao_de_visita.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.botcamp_kotlin_dio_cartao_de_visita.data.BusinessCard
import com.example.botcamp_kotlin_dio_cartao_de_visita.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()){

        var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: BusinessCard) {
            binding.nome.text = item.nome
            binding.email.text = item.email
            binding.telefone.text = item.telefone
            binding.empresa.text = item.empresa
//            binding.logoempresa.drawable = item.logo
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.background))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
            binding.nome.text = item.nome
        }
    }


}


class DiffCallback: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
    }

