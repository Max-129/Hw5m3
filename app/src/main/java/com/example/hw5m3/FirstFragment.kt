package com.example.hw5m3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw5m3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: FilmAdapter
    private lateinit var list:ArrayList<Model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = FilmAdapter(list,this::onClick)
        binding.recyclerview.adapter = adapter
    }

    private fun loadData() {
        list = ArrayList()
        list.add(Model(R.drawable.img,"",""))
        list.add(Model(R.drawable.img_1,"",""))
        list.add(Model(R.drawable.img_2,"",""))
        list.add(Model(R.drawable.img_3,"",""))
        list.add(Model(R.drawable.img_4,"",""))
    }

    private fun onClick(pos:Int) {
        val bundle = Bundle()
        bundle.putSerializable("key",list[pos])
        findNavController().navigate(R.id.secondFragment,bundle)
    }
}