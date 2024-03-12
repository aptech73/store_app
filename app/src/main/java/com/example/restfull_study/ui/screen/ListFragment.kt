package com.example.restfull_study.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restfull_study.R
import com.example.restfull_study.data.remote.model.Product
import com.example.restfull_study.databinding.FragmentListBinding
import com.example.restfull_study.ui.adapter.ListLoadStateAdapter
import com.example.restfull_study.ui.adapter.ListProductsAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding : FragmentListBinding? = null
    val binding
        get() = _binding!!

    private val listProductsAdapter = ListProductsAdapter()

    private val viewModel : ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.products.collectLatest {
                    listProductsAdapter.submitData(it)
                }
            }
        }
    }

    private fun setUi() {
        binding.apply {
            listProducts.adapter = listProductsAdapter.withLoadStateHeaderAndFooter(
                footer = ListLoadStateAdapter(),
                header = ListLoadStateAdapter()
            )
            listProducts.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}