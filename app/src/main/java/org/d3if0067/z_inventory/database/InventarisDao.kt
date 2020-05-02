package org.d3if0067.z_inventory.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InventarisDao {
    @Query("SELECT * FROM inventaris")
    fun getInventaris(): LiveData<List<InventarisDatabaseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(inventaris: List<InventarisDatabaseModel>)
}