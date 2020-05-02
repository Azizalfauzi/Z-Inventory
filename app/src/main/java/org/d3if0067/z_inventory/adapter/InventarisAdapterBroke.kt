package org.d3if0067.z_inventory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.d3if0067.z_inventory.R
import org.d3if0067.z_inventory.databinding.RecylerviewBrokeInventoryBinding
import org.d3if0067.z_inventory.model2.Inventaris2

@Suppress("SpellCheckingInspection")
class InventarisAdapterBroke(
    private val inventaris2: List<Inventaris2>)
    : RecyclerView.Adapter<InventarisAdapterBroke.InventarisBrokeViewHolder>() {

    var listener: RecylerViewClickListener2? = null

    inner class InventarisBrokeViewHolder(
        val itemInventarisBrokeBinding: RecylerviewBrokeInventoryBinding
    ) : RecyclerView.ViewHolder(itemInventarisBrokeBinding.root)

    override fun getItemCount() = inventaris2.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InventarisBrokeViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recylerview_broke_inventory, parent, false
        )
    )


    override fun onBindViewHolder(holder: InventarisBrokeViewHolder, position: Int) {
        holder.itemInventarisBrokeBinding.tvNamaBarangBroke.text = inventaris2[position].namaBarang
        holder.itemInventarisBrokeBinding.tvJumlahBarangBroke.text = inventaris2[position].jumlahBarang

        holder.itemInventarisBrokeBinding.listBrokeInventory.setOnClickListener {
            listener?.onItemClicked2(it, inventaris2[position])
        }
    }
}