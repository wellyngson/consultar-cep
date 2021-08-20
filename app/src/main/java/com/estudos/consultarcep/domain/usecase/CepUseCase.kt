package com.estudos.consultarcep.domain.usecase

import com.estudos.consultarcep.data.model.Cep
import com.estudos.consultarcep.data.repository.RepositoryImpl

class CepUseCase(
    private val repositoryImpl: RepositoryImpl
) {

    suspend fun getAddress(cep: String): Cep {
        return repositoryImpl.getAddress(cep)
    }
}