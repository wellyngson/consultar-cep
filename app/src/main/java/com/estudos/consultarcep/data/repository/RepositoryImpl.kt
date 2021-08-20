package com.estudos.consultarcep.data.repository

import com.estudos.consultarcep.data.model.Cep
import com.estudos.consultarcep.data.services.CepServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RepositoryImpl(
    private val services: CepServices
) : Repository {
    override suspend fun getAddress(cep: String): Cep {

        return try {
            withContext(Dispatchers.IO) {
                services.getAddress(cep)
            }
        } catch (exception: Exception) {
            throw Exception(exception.message)
        }
    }
}