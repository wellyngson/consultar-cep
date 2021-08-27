package com.estudos.consultarcep.data.appdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.estudos.consultarcep.data.dao.ContactDao
import com.estudos.consultarcep.data.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract val contactDao: ContactDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "contact_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}