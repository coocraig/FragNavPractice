package com.example.fragmentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navArgument
import com.example.fragmentpractice.databinding.FragmentExtraBinding
import com.example.fragmentpractice.databinding.FragmentHomeBinding


class ExtraFragment : Fragment() {
    private var _binding: FragmentExtraBinding? = null
    private val binding get() = _binding!!


    private lateinit var numO: String
    private lateinit var numT: String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let{
            numO = it.getString("numOne").toString()
            numT = it.getString("numTwo").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExtraBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var first = numO.toDouble()
        var second = numT.toDouble()
        var result = first + second
        binding.result.text = result.toString()
        binding.goBackButton.setOnClickListener{
            val action = ExtraFragmentDirections.actionExtraFragmentToHomeFragment()
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        //Setting binding to null as the view no longer exists
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


}