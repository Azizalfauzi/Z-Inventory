package org.d3if0067.z_inventory.ui.brokeinventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import org.d3if0067.z_inventory.R
import org.d3if0067.z_inventory.adapter.InventarisAdapter
import org.d3if0067.z_inventory.adapter.InventarisAdapterBroke
import org.d3if0067.z_inventory.adapter.RecylerViewClickListener
import org.d3if0067.z_inventory.adapter.RecylerViewClickListener2
import org.d3if0067.z_inventory.model.Inventaris
import org.d3if0067.z_inventory.databinding.FragmentBrokeInventoryBinding
import org.d3if0067.z_inventory.model2.Inventaris2
import org.d3if0067.z_inventory.ui.normalinventory.NormalViewModel

/**
 * A simple [Fragment] subclass.
 */
class BrokeInventory : Fragment(), RecylerViewClickListener2 {
    private lateinit var binding: FragmentBrokeInventoryBinding
    private lateinit var viewModel: BrokeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_broke_inventory, container, false)

        val application = requireNotNull(this.activity).application
        val factory = BrokeViewModel.Factory(application)
        viewModel = ViewModelProvider(this, factory).get(BrokeViewModel::class.java)



        viewModel.inventaris2.observe(viewLifecycleOwner, Observer {
            val datafix = it.distinctBy { inventaris2 -> inventaris2.namaBarang }
            val adapter = InventarisAdapterBroke(datafix)
            val recylerview = binding.rvBrokeInventory
            recylerview.adapter = adapter
            recylerview.layoutManager = LinearLayoutManager(this.requireContext())

            adapter.listener = this
        })

//        viewModel.data.observe({ lifecycle }, {
//            val inventarisAdapter = InventarisAdapter(it)
//            val recyclerView = binding.rvNormalInventory
//
//            inventarisAdapter.listener = this
//            recyclerView.apply {
//                this.adapter = inventarisAdapter
//                this.layoutManager = LinearLayoutManager(requireContext())
//            }
//        })
        viewModel.response.observe({ lifecycle }, {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
        return binding.root

    }

    override fun onItemClicked2(view: View, inventaris2: Inventaris2) {
        val bundle = bundleOf(
            "namaBarang" to inventaris2.namaBarang,
            "jumlahBarang" to inventaris2.jumlahBarang,
            "hargaBarang" to inventaris2.hargaBarang,
            "keteranganBarang" to inventaris2.keteranganBarang,
            "image" to inventaris2.image
        )
        view.findNavController()
            .navigate(R.id.action_broke_inventory_to_detailBrokeFragment, bundle)
    }

}
