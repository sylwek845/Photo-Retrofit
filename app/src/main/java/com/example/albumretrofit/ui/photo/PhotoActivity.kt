package com.example.albumretrofit.ui.photo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.albumretrofit.R
import com.example.albumretrofit.base.BaseActivity
import com.example.albumretrofit.databinding.ActivityPhotoBinding
import com.example.albumretrofit.model.Photo
import com.example.albumretrofit.ui.ItemView
import com.example.albumretrofit.utils.BaseConst.Companion.ALBUM_ID

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
@Suppress("UNCHECKED_CAST")
class PhotoActivity : BaseActivity<PhotoPresenter>(), ItemView {

    private var albumId: Int = 0
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityPhotoBinding

    /**
     * The adapter for the list of photos
     */
    private val photosAdapter = PhotoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        albumId = intent.getIntExtra(ALBUM_ID, 0)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo)
        binding.adapter = photosAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated(albumId)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateItem(items: List<*>) {
        photosAdapter.updatePhotos(items as List<Photo>)
    }


    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
        binding.listVisibility = View.INVISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
        binding.listVisibility = View.VISIBLE
    }

    override fun instantiatePresenter(): PhotoPresenter {
        return PhotoPresenter(this)
    }
}
