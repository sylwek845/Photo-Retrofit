package com.example.albumretrofit.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.example.albumretrofit.ui.album.AlbumAdapter
import com.example.albumretrofit.ui.photo.PhotoAdapter

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: AlbumAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: PhotoAdapter) {
    view.adapter = adapter
}

/**
 * Sets a LayoutManager to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the LayoutManager
 * @param layoutManager the LayoutManager to set to the RecyclerView
 */
@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

/**
 * Adds a DividerItemDecoration to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the DividerItemDecoration
 * @param dividerItemDecoration the DividerItemDecoration to set to the RecyclerView
 */
@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}