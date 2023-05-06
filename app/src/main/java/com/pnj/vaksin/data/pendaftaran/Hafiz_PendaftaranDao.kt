package com.pnj.vaksin.data.pendaftaran

import androidx.room.*

@Dao
interface Hafiz_PendaftaranDao {
    @Query("SELECT * FROM pendaftar WHERE nama_pendaftar LIKE :namaPendaftar")
    suspend fun searchPendaftaran(namaPendaftar: String) : List<Hafiz_Pendaftaran>

    @Insert
    suspend fun addPendaftaran(pendaftaran: Hafiz_Pendaftaran)

    @Update(entity = Hafiz_Pendaftaran::class)
    suspend fun updatePendaftaran(pendaftaran: Hafiz_Pendaftaran)

    @Delete
    suspend fun deletePendaftaran(pendaftaran: Hafiz_Pendaftaran)

    @Query("SELECT * FROM pendaftar")
    suspend fun getAllPendaftaran(): List<Hafiz_Pendaftaran>


}