package com.estudos.consultarcep.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String?,
    val phone: Long?,
    @Embedded
    val address: Address?
) : Parcelable