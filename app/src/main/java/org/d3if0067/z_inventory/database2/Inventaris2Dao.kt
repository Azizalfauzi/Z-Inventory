package org.d3if0067.z_inventory.database2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Inventaris2Dao {
    @Query("SELECT * FROM inventaris2")
    fun getInventaris2():LiveData<List<InventarisDatabaseModel2>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll2(inventaris2:List<InventarisDatabaseModel2>)

}