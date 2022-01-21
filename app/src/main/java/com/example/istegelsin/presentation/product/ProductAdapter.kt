package com.example.istegelsin.presentation.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.istegelsin.databinding.HomeCardViewBinding
import com.example.istegelsin.domain.Product

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
                }
            }
            is ProductAdapterViewHolder.HomeCardViewHolder -> {
                var count = 1

                holder.cardView.products = mList[position]
                holder.cardView.cardViewPlus.setOnClickListener {
                    holder.cardView.cardViewPlus.visibility = View.INVISIBLE
                    holder.cardView.cardviewAddDelete.visibility = View.VISIBLE
                }

                holder.cardView.cardViewPlus.setOnClickListener {
                    count++
                    holder.cardView.cardViewCount.text = count.toString()
                    if (count>1){
                        holder.cardView.cardViewDelete.visibility= View.INVISIBLE
                        holder.cardView.cardViewMinus.visibility= View.VISIBLE
                    }
                    else if (count==1){
                        holder.cardView.cardViewDelete.visibility = View.VISIBLE
                        holder.cardView.cardViewMinus.visibility = View.INVISIBLE
                    }
                    else{
                        holder.cardView.cardViewPlus.visibility = View.VISIBLE
                        holder.cardView.cardviewAddDelete.visibility = View.INVISIBLE
                    }
                }

                holder.cardView.cardViewMinus.setOnClickListener {
                    count--
                    holder.cardView.cardViewCount.text = count.toString()
                    if (count>1){
                        holder.cardView.cardViewDelete.visibility= View.INVISIBLE
                        holder.cardView.cardViewMinus.visibility= View.VISIBLE
                    }
                    else if (count==1){
                        holder.cardView.cardViewDelete.visibility = View.VISIBLE
                        holder.cardView.cardViewMinus.visibility = View.INVISIBLE
                    }
                    else{
                        holder.cardView.cardViewPlus.visibility = View.VISIBLE
                        holder.cardView.cardviewAddDelete.visibility = View.INVISIBLE
                    }

                }
                holder.cardView.cardViewDelete.setOnClickListener {
                    holder.cardView.cardViewPlus.visibility = View.VISIBLE
                    holder.cardView.cardviewAddDelete.visibility = View.INVISIBLE
                }
            }
            }
    }
}