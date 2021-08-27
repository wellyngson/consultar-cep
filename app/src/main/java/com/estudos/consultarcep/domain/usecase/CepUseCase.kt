package com.estudos.consultarcep.domain.usecase

import com.estudos.consultarcep.data.model.Contact
import com.estudos.consultarcep.data.repository.RepositoryImpl
import retrofit2.Response

class CepUseCase(
    private val repositoryImpl: RepositoryImpl
) {

    suspend fun getAddress(cep: String): Contact {
        return repositoryImpl.getAddress(cep)
    }
}