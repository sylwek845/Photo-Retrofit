package com.example.albumretrofit.ui.album

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.albumretrofit.R
import com.example.albumretrofit.databinding.ItemAlbumBinding
import com.example.albumretrofit.model.Album

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
class AlbumAdapter(private val context: Context, private val albumClicked: AlbumClicked) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemAlbumBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_album, p0, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(p0: AlbumViewHolder, p1: Int) {
        p0.bind(albums[p1], this)
    }

    /**
     * The list of albums of the adapter
     */
    private var albums: List<Album> = arrayListOf()

    override fun getItemCount(): Int {
        return albums.size
    }

    fun clicked(album: Album) {
        albumClicked.clicked(album.id)
    }

    /**
     * Updates the list of albums of the adapter
     * @param albums the new list of albums of the adapter
     */
    fun updateAlbums(albums: List<Album>) {
        this.albums = albums
        notifyDataSetChanged()
    }

    /**
     * Sort the list of albums of the adapter
     */
    fun sortByTitle() {
        albums = this.albums.sortedWith(compareBy { it.title })
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Album item
     */
    class AlbumViewHolder(private val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a album into the view
         */
        fun bind(album: Album, albumAdapter: AlbumAdapter) {
            binding.album = album
            binding.adapter = albumAdapter
            binding.executePendingBindings()
        }
    }
}
