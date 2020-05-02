package org.d3if0067.z_inventory.database2

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.d3if0067.z_inventory.model2.Inventaris2
import org.d3if0067.z_inventory.model2.TABLE_NAME2

@Entity(tableName = TABLE_NAME2)
data class InventarisDatabaseModel2 constructor(
    @PrimaryKey
    val namaBarang: String,
    val jumlahBarang: String,
    val hargaBarang: String,
    val keteranganBarang: String,
    val image: String
)

fun convertToDomainModel2(data: List<InventarisDatabaseModel2>): List<Inventaris2> {
    return data.map {
        Inventaris2(
            namaBarang = it.namaBarang,
            jumlahBarang = it.jumlahBarang,
            hargaBarang = it.hargaBarang,
            keteranganBarang = it.keteranganBarang,
            image = it.image
        )
    }
}

fun convertToDatabaseModel2(data: List<Inventaris2>): List<InventarisDatabaseModel2> {
    return data.map {
        InventarisDatabaseModel2(
            namaBarang = it.namaBarang,
            jumlahBarang = it.jumlahBarang,
            hargaBarang = it.hargaBarang,
            keteranganBarang = it.keteranganBarang,
            image = it.image
        )
    }
}