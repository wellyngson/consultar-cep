package com.estudos.consultarcep.data.repository

import com.estudos.consultarcep.data.dao.ContactDao
import com.estudos.consultarcep.data.model.Address
import com.estudos.consultarcep.data.model.Contact
import com.estudos.consultarcep.data.services.CepServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class RepositoryImpl(
    private val dao: ContactDao,
    private val services: CepServices
) : Repository {
    override suspend fun getAddress(cep: String): Contact {
        val address: Response<Address>
        val contact: Contact

        return try {
            withContext(Dispatchers.IO) {
                address = services.getAddress(cep = cep)

                if (address.isSuccessful) {

//                    dao.insert(contact)
                }
                contact = Contact(
                    0,
                    "teste",
                    988121935,
                    address.body()
                )
            }
            contact

        } catch (exception: Exception) {
            throw Exception(exception.message)
        }
    }
}