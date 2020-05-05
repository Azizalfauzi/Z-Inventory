package org.d3if0067.z_inventory.utils

import android.view.View
import org.d3if0067.z_inventory.model.Inventaris

interface RecylerViewClickListener {
    fun onItemClicked(view: View, inventaris: Inventaris)
}