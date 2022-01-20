package com.example.istegelsin.presentation.product

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.istegelsin.databinding.HomeCardViewBinding

open class ProductAdapterViewHolder(val binding: View) : RecyclerView.ViewHolder(binding)  {
    class HomeCardViewHolder(val cardView: HomeCardViewBinding): ProductAdapterViewHolder(cardView.root)
}