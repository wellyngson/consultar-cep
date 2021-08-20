package com.estudos.consultarcep.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudos.consultarcep.data.model.Cep
import com.estudos.consultarcep.domain.usecase.CepUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: CepUseCase
): ViewModel() {

    private val cepMutableLiveData = MutableLiveData<Cep>()
    val cepLiveData: LiveData<Cep> = cepMutableLiveData

    fun init(cep: String) {
        getAddress(cep)
    }

    private fun getAddress(cep: String) {
        viewModelScope.launch {
            val address = useCase.getAddress(cep)
            cepMutableLiveData.postValue(address)
        }
    }
}