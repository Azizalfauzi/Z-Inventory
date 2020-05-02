package org.d3if0067.z_inventory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recylerview_normal_inventory.view.*
import org.d3if0067.z_inventory.R
import org.d3if0067.z_inventory.database.Inventaris
import org.d3if0067.z_inventory.databinding.RecylerviewNormalInventoryBinding

class InventarisAdapter(
    private val inventaris: List<Inventaris>
) : RecyclerView.Adapter<InventarisAdapter.InventarisViewHolder>() {

    var listener: RecylerViewClickListener? = null

    inner class InventarisViewHolder(
        val itemInventarisBinding: RecylerviewNormalInventoryBinding
    ) : RecyclerView.ViewHolder(itemInventarisBinding.root)

    override fun getItemCount() = inventaris.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InventarisViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recylerview_normal_inventory, parent, false
        )
    )


    override fun onBindViewHolder(holder: InventarisViewHolder, position: Int) {
        holder.itemInventarisBinding.tvNamaNormal.text = inventaris[position].namaBarang
        holder.itemInventarisBinding.tvJumlahNormal.text = inventaris[position].jumlahBarang

        holder.itemInventarisBinding.listNormalInventory.setOnClickListener {
            listener?.onItemClicked(it, inventaris[position])
        }
    }
}