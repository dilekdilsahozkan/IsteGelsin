package com.example.istegelsin.presentation.category

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.istegelsin.databinding.HomeCardViewBinding
import com.example.istegelsin.databinding.HomeCategoryOneBinding
import com.example.istegelsin.databinding.HomeCategoryTwoBinding

open class CategoryAdapterViewHolder (val binding: View) : RecyclerView.ViewHolder(binding) {
    class HomeCategoryOneViewHolder(val oneView: HomeCategoryOneBinding): CategoryAdapterViewHolder(oneView.root)
    class HomeCategoryTwoViewHolder(val twoView: HomeCategoryTwoBinding): CategoryAdapterViewHolder(twoView.root)
    class HomeCardViewHolder(val cardView: HomeCardViewBinding): CategoryAdapterViewHolder(cardView.root)
}