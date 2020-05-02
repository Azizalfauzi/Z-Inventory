package org.d3if0067.z_inventory.ui.detailbroke

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import org.d3if0067.z_inventory.R
import org.d3if0067.z_inventory.databinding.FragmentDetailBrokeBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailBrokeFragment : Fragment() {
    private lateinit var binding: FragmentDetailBrokeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_broke, container, false)
        if (arguments != null) {
            val namaBarang = arguments?.getString("namaBarang")
            val jumlahBarang = arguments?.getString("jumlahBarang")
            val hargaBarang = arguments?.getString("hargaBarang")
            val keteranganBarang = arguments?.getString("keteranganBarang")
            val image = arguments?.getString("image")

            binding.tvNamaBarangBroke.text = namaBarang.toString()
            binding.tvJumlahBarangBroke.text = hargaBarang.toString()
            binding.tvHargaBarangBroke.text = jumlahBarang.toString()
            binding.tvKeteranganBarangBroke.text = keteranganBarang.toString()

            Glide.with(this)
                .load(image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .dontAnimate()
                .into(binding.imageNegara)

        }
        return binding.root

    }

}
