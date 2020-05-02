package org.d3if0067.z_inventory.adapter

import android.view.View
import org.d3if0067.z_inventory.database.Inventaris

interface RecylerViewClickListener {
    fun onItemClicked(view: View, inventaris: Inventaris)
}