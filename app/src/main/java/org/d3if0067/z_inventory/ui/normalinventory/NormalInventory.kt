package org.d3if0067.z_inventory.ui.normalinventory

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
import org.d3if0067.z_inventory.utils.RecylerViewClickListener
import org.d3if0067.z_inventory.model.Inventaris
import org.d3if0067.z_inventory.databinding.FragmentNormalInventoryBinding


/**
 * A simple [Fragment] subclass.
 */
@Suppress("SpellCheckingInspection")
class NormalInventory : Fragment(),
    RecylerViewClickListener {
    private lateinit var binding: FragmentNormalInventoryBinding
    private lateinit var viewModel: NormalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_normal_inventory, container, false)


        val application = requireNotNull(this.activity).application
        val factory = NormalViewModel.Factory(application)
        viewModel = ViewModelProvider(this, factory).get(NormalViewModel::class.java)

        binding.inventarisVm = viewModel
        binding.lifecycleOwner = this

        viewModel.inventaris.observe(viewLifecycleOwner, Observer {
            val datafix = it.distinctBy { inventaris -> inventaris.namaBarang }
            val adapter = InventarisAdapter(datafix)
            val recylerview = binding.rvNormalInventory
            recylerview.adapter = adapter
            recylerview.layoutManager = LinearLayoutManager(this.requireContext())

            adapter.listener = this
        })
        viewModel.response.observe({ lifecycle }, {
            if (it.isNotEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    override fun onItemClicked(view: View, inventaris: Inventaris) {
        val bundle = bundleOf(
            "namaBarang" to inventaris.namaBarang,
            "jumlahBarang" to inventaris.jumlahBarang,
            "hargaBarang" to inventaris.hargaBarang,
            "keteranganBarang" to inventaris.keteranganBarang,
            "image" to inventaris.image
        )
        view.findNavController()
            .navigate(R.id.action_normal_inventory_to_detailNormalFragment, bundle)
    }

}
