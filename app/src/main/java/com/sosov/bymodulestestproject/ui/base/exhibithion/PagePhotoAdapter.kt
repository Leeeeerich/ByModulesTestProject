package com.sosov.bymodulestestproject.ui.base.exhibithion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sosov.bymodulestestproject.R

class PagePhotoAdapter(var photos: List<String>) :
    RecyclerView.Adapter<PagePhotoAdapter.PagePhotoItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagePhotoItem {
        return PagePhotoItem(
            LayoutInflater.from(parent.context).inflate(R.layout.image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PagePhotoItem, position: Int) {
        holder.setPhoto(photos[position])
    }

    override fun getItemCount(): Int = photos.size

    inner class PagePhotoItem(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setPhoto(url: String) {
            Glide
                .with(view)
                .load(url)
                .centerCrop()
                .error(R.drawable.ic_broken_image)
                .into(view.findViewById(R.id.page_image))
        }
    }
}