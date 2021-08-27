package com.estudos.consultarcep.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(
    @SerializedName("cep")
    var postCode: String?,
    @SerializedName("logradouro")
    var road: String?,
    @SerializedName("bairro")
    val district: String?,
    @SerializedName("localidade")
    val city: String?,
    @SerializedName("uf")
    val state: String?,
    @SerializedName("ddd")
    val ddd: String?,
    @SerializedName("erro")
    val erro: String?
) : Serializable