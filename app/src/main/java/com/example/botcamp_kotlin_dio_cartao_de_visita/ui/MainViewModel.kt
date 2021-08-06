package com.example.botcamp_kotlin_dio_cartao_de_visita.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.botcamp_kotlin_dio_cartao_de_visita.data.BusinessCard
import com.example.botcamp_kotlin_dio_cartao_de_visita.data.BusinessCardRepository
import java.lang.IllegalArgumentException

class MainViewModel (private val businessCardRepository: BusinessCardRepository):ViewModel() {

    fun insert (businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll(): LiveData<List<BusinessCard>>{
        return businessCardRepository.getall()
    }
}

class MainViewModelFactory (private val repository: BusinessCardRepository):
        ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}