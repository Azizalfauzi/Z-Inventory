package org.d3if0067.z_inventory.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import org.d3if0067.z_inventory.R
import org.d3if0067.z_inventory.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.btNormalInventory.setOnClickListener { v: View ->
            findNavController().navigate(R.id.action_navigation_home_to_normalInventory)
        }
        binding.btBrokeInventory.setOnClickListener { b: View ->
            findNavController().navigate(R.id.action_navigation_home_to_broke_inventory)
        }
        return binding.root
    }
}
