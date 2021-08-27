package com.estudos.consultarcep.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudos.consultarcep.data.model.Contact
import com.estudos.consultarcep.domain.usecase.CepUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: CepUseCase
): ViewModel() {

    private val addressMutableLiveData = MutableLiveData<List<Contact>>()
    val addressLiveData: LiveData<List<Contact>> = addressMutableLiveData

    fun init(postCode: String) {
        getAddress(postCode)
    }

    private fun getAddress(postCode: String) {
        viewModelScope.launch {
            val contact = useCase.getAddress(postCode)
            addressMutableLiveData.postValue(contact)
        }
    }
}
