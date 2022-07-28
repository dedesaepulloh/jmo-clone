package com.dedesaepulloh.assesment.presentation.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dedesaepulloh.assesment.databinding.FragmentProfileBinding
import com.dedesaepulloh.assesment.presentation.LoginActivity
import com.dedesaepulloh.assesment.presentation.MainActivity

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgExit.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
    }

}