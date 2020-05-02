package org.d3if0067.z_inventory.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.d3if0067.z_inventory.database.InventarisDatabase
import org.d3if0067.z_inventory.database.convertToDatabaseModel
import org.d3if0067.z_inventory.database.convertToDomainModel
import org.d3if0067.z_inventory.model.Inventaris
import org.d3if0067.z_inventory.network.ApiInventaris

@Suppress("SpellCheckingInspection")
class InventarisRepository(private val database: InventarisDatabase) {
    val inventaris: LiveData<List<Inventaris>> =
        Transformations.map(database.inventarisDao.getInventaris()) {
            convertToDomainModel(it)
        }

    suspend fun refreshInventaris() {
        withContext(Dispatchers.IO) {
            val inventaris = ApiInventaris.retrofitService.showList()
            database.inventarisDao.insertAll(convertToDatabaseModel(inventaris))
        }
    }
}