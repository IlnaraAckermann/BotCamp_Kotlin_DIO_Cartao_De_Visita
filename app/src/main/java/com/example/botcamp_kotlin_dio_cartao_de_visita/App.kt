package com.example.botcamp_kotlin_dio_cartao_de_visita

import android.app.Application
import com.example.botcamp_kotlin_dio_cartao_de_visita.data.AppDatabase
import com.example.botcamp_kotlin_dio_cartao_de_visita.data.BusinessCardRepository

class App : Application(){
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy {BusinessCardRepository(database.businessDao())}


}