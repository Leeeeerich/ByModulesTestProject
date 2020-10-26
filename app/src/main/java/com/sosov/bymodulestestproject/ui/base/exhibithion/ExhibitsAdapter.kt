package com.sosov.bymodulestestproject.ui.base.exhibithion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sosov.bymodulestestproject.databinding.ItemExhibitBinding
import com.sosov.bymodulestestproject.ui.base.exhibithion.ExhibitsAdapter.ExhibitViewHolder
import com.sosov.model.Exhibit

class ExhibitsAdapter : RecyclerView.Adapter<ExhibitViewHolder>() {

    var exhibits = mutableListOf<Exhibit>()
        set(value) {
            if (field.size > 0) exhibits.clear()
            field.addAll(value)
            notifyDataSetChanged() //TODO upgrade with pagination and DiffUtil
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExhibitViewHolder(
        ItemExhibitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        holder.bind(exhibits[position])
    }

    override fun getItemCount(): Int = exhibits.size

    inner class ExhibitViewHolder(private val binding: ItemExhibitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Exhibit) {
            binding.tvTitle.text = data.title
            binding.viewPager2.adapter = PagePhotoAdapter(data.images)
        }
    }
}