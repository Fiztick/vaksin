package com.pnj.vaksin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pnj.vaksin.data.pendaftaran.Hafiz_Pendaftaran
import com.pnj.vaksin.data.pendaftaran.Hafiz_PendaftaranDao

@Database(entities = [Hafiz_Pendaftaran::class], version = 1, exportSchema = false)

abstract class Hafiz_VaksinDatabase : RoomDatabase(){

    abstract fun getPendaftaranDao(): Hafiz_PendaftaranDao

    companion object {
        @Volatile
        private var instance: Hafiz_VaksinDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder (
            context.applicationContext,
            Hafiz_VaksinDatabase::class.java,
            "vaksin-db"
        ).build()
    }
}