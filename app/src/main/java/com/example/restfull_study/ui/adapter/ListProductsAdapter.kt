package com.example.restfull_study.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restfull_study.data.remote.model.Product
import com.example.restfull_study.databinding.ItemProductBinding

class ListProductsAdapter : ListAdapter<Product, ListProductsAdapter.ListProductsViewHolder>(ListProductsDiffCallback) {
    private object ListProductsDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    inner class ListProductsViewHolder(
        private val binding : ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product : Product) {
            binding.apply {
                titleProduct.text = product.title
                descProduct.text = product.description
                Glide.with(binding.root).load(product.thumbnail).into(imageProduct)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProductsViewHolder {
        return ListProductsViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ListProductsViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }
}