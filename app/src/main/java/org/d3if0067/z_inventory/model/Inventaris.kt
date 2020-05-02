package org.d3if0067.z_inventory.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Suppress("SpellCheckingInspection")
@JsonClass(generateAdapter = true)
data class Inventaris(
    val namaBarang: String,
    val jumlahBarang: String,
    val hargaBarang: String,
    val keteranganBarang: String,
    val image: String
)