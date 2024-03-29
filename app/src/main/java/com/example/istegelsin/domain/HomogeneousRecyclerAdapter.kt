package com.example.istegelsin.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.istegelsin.data.local.entity.CategoryEntity

class HomogeneousRecyclerAdapter<Binding : ViewDataBinding, Model>(
    private val items: List<Model>,
    private val layoutId: Int,
    private val modelId: Int,
    private val onClick: (Model) -> Unit = {}
) : RecyclerView.Adapter<HomogeneousRecyclerAdapter.ViewHolder<Binding>>() {

    class ViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder<Binding> (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder<Binding>, position: Int) {
        holder.binding.setVariable(modelId, items[position])
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener { onClick(items[position%items.size]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
