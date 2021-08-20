package com.estudos.consultarcep.data.repository

import com.estudos.consultarcep.data.model.Cep

interface Repository {
    suspend fun getAddress(cep: String): Cep
}