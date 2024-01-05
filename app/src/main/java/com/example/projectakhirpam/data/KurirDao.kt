package com.example.projectakhirpam.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KurirDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kurir: Kurir)

    @Update
    suspend fun update(kurir: Kurir)

    @Delete
    suspend fun delete(kurir: Kurir)

    @Query("SELECT * from tblSiswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Kurir>

    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Kurir>>
}