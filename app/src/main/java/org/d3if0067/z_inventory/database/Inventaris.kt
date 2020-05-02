package org.d3if0067.z_inventory.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Inventaris(
    val namaBarang: String,
    val jumlahBarang: String,
    val hargaBarang: String,
    val keteranganBarang: String,
    val image: String
) : Parcelable