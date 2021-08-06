package com.example.botcamp_kotlin_dio_cartao_de_visita.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private val dao: BusinessCardDao){
    fun insert (businessCard: BusinessCard) = runBlocking {
        launch (Dispatchers.IO) {
            dao.insert(businessCard)
        }
    }

    fun getall()=dao.getAll()
}