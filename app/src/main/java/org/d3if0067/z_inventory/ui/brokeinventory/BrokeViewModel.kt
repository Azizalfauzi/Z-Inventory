package org.d3if0067.z_inventory.ui.brokeinventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if0067.z_inventory.database.Inventaris
import org.d3if0067.z_inventory.network.ApiInventaris
import org.d3if0067.z_inventory.network.ApiInventaris2

class BrokeViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Inventaris>>()
    val data: LiveData<List<Inventaris>>
        get() = _data

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    init {
        _response.value = ""
        initData()
    }

    fun initData() {
        uiScope.launch {
            try {
                val result = ApiInventaris2.retrofitService2.showList()
                if (result.isNotEmpty()) {
                    _data.value = result
                    _response.value = "Data Berhasil DiAmbil"
                } else {
                    _response.value = "Data Inventaris Kosong"
                }
            } catch (t: Throwable) {
                _response.value = "Tidak ada koneksi Internet"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}