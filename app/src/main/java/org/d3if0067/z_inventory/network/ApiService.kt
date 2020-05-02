package org.d3if0067.z_inventory.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0067.z_inventory.database.Inventaris
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://firebasestorage.googleapis.com/v0/b/rizkifar-project.appspot.com/o/"
const val BASE_GET= "normal-inventory.json?alt=media&token=669392da-b080-4aad-a8e6-b4fda47a06dc"
const val BASE_GET2 ="broke-inventory.json?alt=media&token=002b0b85-13ae-4dd7-b511-65b1edb4baf7"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET(BASE_GET)
    suspend fun showList(): List<Inventaris>
}
interface ApiService2 {
    @GET(BASE_GET2)
    suspend fun showList(): List<Inventaris>
}

object ApiInventaris {
    val retrofitService = retrofit.create(ApiService::class.java)
}
object ApiInventaris2 {
    val retrofitService2 = retrofit2.create(ApiService2::class.java)
}
