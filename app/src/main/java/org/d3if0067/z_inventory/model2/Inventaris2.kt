package org.d3if0067.z_inventory.model2

import com.squareup.moshi.JsonClass

@Suppress("SpellCheckingInspection")
@JsonClass(generateAdapter = true)
data class Inventaris2(
    val namaBarang: String,
    val jumlahBarang: String,
    val hargaBarang: String,
    val keteranganBarang: String,
    val image: String
)