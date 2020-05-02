package org.d3if0067.z_inventory.ui.detailnormal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import org.d3if0067.z_inventory.R
import org.d3if0067.z_inventory.database.Inventaris
import org.d3if0067.z_inventory.databinding.FragmentDetailNormalBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailNormalFragment : Fragment() {
    private lateinit var binding: FragmentDetailNormalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_normal, container, false)
        if (arguments != null) {
            val namaBarang = arguments?.getString("namaBarang")
            val jumlahBarang = arguments?.getString("jumlahBarang")
            val hargaBarang = arguments?.getString("hargaBarang")
            val keteranganBarang = arguments?.getString("keteranganBarang")
            val image = arguments?.getString("image")

            binding.tvNamaBarang.text = namaBarang.toString()
            binding.tvJumlahBarang.text = hargaBarang.toString()
            binding.tvHargaBarang.text = jumlahBarang.toString()
            binding.tvKeteranganBarang.text = keteranganBarang.toString()

            Glide.with(this)
                .load(image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .dontAnimate()
                .into(binding.imageNegara)
        }

        return binding.root
    }

}
