package com.estudos.consultarcep.data.dao

import androidx.room.*
import com.estudos.consultarcep.data.model.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact?)

    @Delete
    fun delete(contact: Contact)
}