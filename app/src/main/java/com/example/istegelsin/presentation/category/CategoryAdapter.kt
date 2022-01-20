package com.example.istegelsin.presentation.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.istegelsin.R
import com.example.istegelsin.databinding.HomeCategoryOneBinding
import com.example.istegelsin.databinding.HomeCategoryTwoBinding
import com.example.istegelsin.domain.Categories

class CategoryAdapter(private var mList: List<Categories>,  private var itemSelectedListener: ItemSelectedListener): RecyclerView.Adapter<CategoryAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterViewHolder {
        when(viewType) {
            R.layout.home_category_one -> {
                val binding = HomeCategoryOneBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                return CategoryAdapterViewHolder.HomeCategoryOneViewHolder(binding)
            }
            R.layout.home_category_two -> {
                val binding = HomeCategoryTwoBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                return CategoryAdapterViewHolder.HomeCategoryTwoViewHolder(binding)
            }
        }
        val binding = HomeCategoryOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryAdapterViewHolder.HomeCategoryOneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapterViewHolder, position: Int) {
        when(holder){

            is CategoryAdapterViewHolder.HomeCategoryOneViewHolder -> {
                holder.oneView.categoryOneName.text = mList[position].name
                holder.oneView.categoryOne = mList[position]

            }

            is CategoryAdapterViewHolder.HomeCategoryTwoViewHolder -> {
                holder.twoView.categoryTwoName.text = mList[position].name
                holder.twoView.categoryTwo = mList[position]
            }

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}
interface ItemSelectedListener {
    fun onItemSelected(item:Any?)
}