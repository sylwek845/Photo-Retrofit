package com.example.albumretrofit.ui.photo

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.albumretrofit.R
import com.example.albumretrofit.databinding.ItemPhotoBinding
import com.example.albumretrofit.model.Photo

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
class PhotoAdapter(private val context: Context) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemPhotoBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_photo, p0, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(p0: PhotoViewHolder, p1: Int) {
        p0.bind(photos[p1])
    }

    /**
     * The list of photos of the adapter
     */
    private var photos: List<Photo> = listOf()


    override fun getItemCount(): Int {
        return photos.size
    }


    /**
     * Updates the list of photos of the adapter
     * @param photos the new list of photos of the adapter
     */
    fun updatePhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Photo item
     */
    class PhotoViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a photo into the view
         */
        fun bind(photo: Photo) {
            binding.photo = photo
            binding.executePendingBindings()
        }
    }
}