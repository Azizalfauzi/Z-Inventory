package org.d3if0067.z_inventory.ui.normalinventory

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if0067.z_inventory.database.InventarisDatabase
import org.d3if0067.z_inventory.model.Inventaris
import org.d3if0067.z_inventory.network.ApiInventaris
import org.d3if0067.z_inventory.repository.InventarisRepository

class NormalViewModel(application: Application) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    private val database = InventarisDatabase.getInstance(application)
    private val inventarisRepository = InventarisRepository(database)


    init {
        _response.value = ""
        _loading.value = true
        uiScope.launch {
            try {
                inventarisRepository.refreshInventaris()
                _response.value = "Berhasil ambil data dari room"
            } catch (t: Throwable) {
                _response.value = "Tidak ada koneksi internet!"
            } finally {
                _loading.value = false
            }
        }
    }

    val inventaris = inventarisRepository.inventaris

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NormalViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NormalViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}