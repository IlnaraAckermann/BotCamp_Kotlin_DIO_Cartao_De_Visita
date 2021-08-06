package com.example.botcamp_kotlin_dio_cartao_de_visita.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.botcamp_kotlin_dio_cartao_de_visita.App
import com.example.botcamp_kotlin_dio_cartao_de_visita.R
import com.example.botcamp_kotlin_dio_cartao_de_visita.data.BusinessCard
import com.example.botcamp_kotlin_dio_cartao_de_visita.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy {ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel:MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.close.setOnClickListener(){
            finish()
        }


        binding.btConfirm.setOnClickListener{
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                telefone= binding.tilEmail.editText?.text.toString(),
                background = binding.tilBackground.editText?.text.toString(),
                logo =""
            )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.card_insert_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }



    }
}