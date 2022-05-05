package com.example.dicerollgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dicerollgame.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.rulesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_rulesFragment)
        }
        binding.playBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_gameFragment)
        }
        return binding.root
    }
}