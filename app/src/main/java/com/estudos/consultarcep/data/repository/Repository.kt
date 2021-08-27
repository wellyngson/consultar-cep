package com.estudos.consultarcep.data.repository

import com.estudos.consultarcep.data.model.Address
import com.estudos.consultarcep.data.model.Contact
import retrofit2.Response

interface Repository {
    suspend fun getAddress(cep: String): Response<Contact>
}