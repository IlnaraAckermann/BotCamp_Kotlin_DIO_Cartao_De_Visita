package com.example.botcamp_kotlin_dio_cartao_de_visita.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.botcamp_kotlin_dio_cartao_de_visita.App
import com.example.botcamp_kotlin_dio_cartao_de_visita.databinding.ActivityMainBinding
import com.example.botcamp_kotlin_dio_cartao_de_visita.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel:MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBusinessCard.adapter =adapter
        getAllBusinessCard()
        insertListener()

    }

    private fun insertListener(){
        binding.floatAdd.setOnClickListener{
            val intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java )
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllBusinessCard (){
        mainViewModel.getAll().observe(this,{ businessCards ->
            adapter.submitList(businessCards)
        })
    }

}