package com.sosov.bymodulestestproject.ui.base.exhibithion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sosov.bymodulestestproject.R
import com.sosov.bymodulestestproject.databinding.FragmentExhibiteBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ExhibitionFragment : Fragment() {

    private lateinit var binding: FragmentExhibiteBinding
    private lateinit var adapter: ExhibitsAdapter
    private val vm: ExhibitionModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exhibite, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ExhibitsAdapter()
        binding.rvExhibit.adapter = adapter

        observableExhibits()

        vm.init()
    }

    private fun observableExhibits() {
        vm.getExhibitsLiveData().observe(viewLifecycleOwner, {
            if (it != null) {
                adapter.exhibits = it.toMutableList()
            }
        })
    }
}