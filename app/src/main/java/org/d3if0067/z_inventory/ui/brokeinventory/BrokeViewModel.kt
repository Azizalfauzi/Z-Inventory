package org.d3if0067.z_inventory.ui.brokeinventory

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if0067.z_inventory.database2.Inventaris2Database
import org.d3if0067.z_inventory.model2.Inventaris2
import org.d3if0067.z_inventory.repository2.InventarisRepository2

@Suppress("SpellCheckingInspection")
class BrokeViewModel(application: Application) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    private val database = Inventaris2Database.getInstance2(application)
    private val inventarisRepository2 = InventarisRepository2(database)

    init {
        _loading.value = true
        uiScope.launch {
            try {
                inventarisRepository2.refreshInventaris2()
                _response.value = "Berhasil ambil data dari room"
            } catch (t: Throwable) {
                _response.value = "Tidak ada koneksi internet!"
            } finally {
                _loading.value = false
            }
        }
    }

    val inventaris2 = inventarisRepository2.inventaris2

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BrokeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return BrokeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }


}