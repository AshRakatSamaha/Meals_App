package com.example.mealsapp.modules.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealsapp.R
import com.example.mealsapp.databinding.ItemMealsBinding
import com.example.mealsapp.domain.entity.Category

class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    inner class MealsViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemMealsBinding.bind(viewItem)

    }

    private val differCallback = object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category,
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category,
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MealsViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_meals,
                    parent,
                    false
                )
        return MealsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {

        val category = differ.currentList[position]
        val context = holder.itemView.context
        holder.binding.apply {
            Glide.with(context).load(category.strCategoryThumb).into(imageMeal)
            nameMeal.text = category.strCategory
            desMeal.text = category.strCategoryDescription


        }

    }

}
