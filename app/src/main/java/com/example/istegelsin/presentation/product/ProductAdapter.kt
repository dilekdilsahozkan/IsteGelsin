package com.example.istegelsin.presentation.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.istegelsin.R
import com.example.istegelsin.databinding.HomeCardViewBinding
import com.example.istegelsin.domain.HomogeneousRecyclerAdapter
import com.example.istegelsin.domain.Product
import com.example.istegelsin.domain.ProductLists
import com.example.istegelsin.presentation.category.ItemSelectedListener

class ProductAdapter(private var mList: List<Product>): RecyclerView.Adapter<ProductAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val binding = HomeCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductAdapterViewHolder.HomeCardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        when(holder){
            is ProductAdapterViewHolder.HomeCardViewHolder -> {
                holder.cardView.products = mList[position]

                holder.cardView.addProduct.setOnClickListener {
                    //  holder.cardView.addProduct.setBackgroundResource(R.drawable.ic_bookmark_filled)
                }
            }
            }
    }
}