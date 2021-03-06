package com.estudos.consultarcep.data.services

import com.estudos.consultarcep.data.model.Address
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CepServices {

    @GET("{cep}/json")
    suspend fun getAddress(@Path("cep") cep: String): Response<Address>
}