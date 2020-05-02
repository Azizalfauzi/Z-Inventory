package org.d3if0067.z_inventory.repository2

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.d3if0067.z_inventory.database2.Inventaris2Database
import org.d3if0067.z_inventory.database2.convertToDatabaseModel2
import org.d3if0067.z_inventory.database2.convertToDomainModel2
import org.d3if0067.z_inventory.model2.Inventaris2
import org.d3if0067.z_inventory.network.ApiInventaris2

@Suppress("SpellCheckingInspection")
class InventarisRepository2(private val database: Inventaris2Database) {
    val inventaris2: LiveData<List<Inventaris2>> =
        Transformations.map(database.inventaris2Dao.getInventaris2()) {
            convertToDomainModel2(it)
        }

    suspend fun refreshInventaris2() {
        withContext(Dispatchers.IO) {
            val inventaris2 = ApiInventaris2.retrofitService2.showList()
            database.inventaris2Dao.insertAll2(convertToDatabaseModel2(inventaris2))
        }
    }

}
