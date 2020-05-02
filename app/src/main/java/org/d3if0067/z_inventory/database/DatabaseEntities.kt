@file:Suppress("SpellCheckingInspection")
package org.d3if0067.z_inventory.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.d3if0067.z_inventory.model.Inventaris
import org.d3if0067.z_inventory.model.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class InventarisDatabaseModel constructor(
    @PrimaryKey
    val namaBarang: String,
    val jumlahBarang: String,
    val hargaBarang: String,
    val keteranganBarang: String,
    val image: String
)

fun convertToDomainModel(data: List<InventarisDatabaseModel>): List<Inventaris> {
    return data.map {
        Inventaris(
            namaBarang = it.namaBarang,
            jumlahBarang = it.jumlahBarang,
            hargaBarang = it.hargaBarang,
            keteranganBarang = it.keteranganBarang,
            image = it.image
        )
    }
}

fun convertToDatabaseModel(data: List<Inventaris>): List<InventarisDatabaseModel> {
    return data.map {
        InventarisDatabaseModel(
            namaBarang = it.namaBarang,
            jumlahBarang = it.jumlahBarang,
            hargaBarang = it.hargaBarang,
            keteranganBarang = it.keteranganBarang,
            image = it.image
        )
    }
}