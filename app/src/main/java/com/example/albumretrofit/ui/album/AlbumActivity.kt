package com.example.albumretrofit.ui.album

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.albumretrofit.R
import com.example.albumretrofit.base.BaseActivity
import com.example.albumretrofit.databinding.ActivityAlbumBinding
import com.example.albumretrofit.model.Album
import com.example.albumretrofit.ui.ItemView
import com.example.albumretrofit.ui.photo.PhotoActivity
import com.example.albumretrofit.utils.BaseConst.Companion.ALBUM_ID

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
@Suppress("UNCHECKED_CAST")
class AlbumActivity : BaseActivity<AlbumPresenter>(), ItemView, AlbumClicked {


    private lateinit var binding: ActivityAlbumBinding
    private val albumAdapter = AlbumAdapter(this, this)
    override fun instantiatePresenter(): AlbumPresenter {
        return AlbumPresenter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_album)
        binding.adapter = albumAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateItem(items: List<*>) {
        albumAdapter.updateAlbums(items as List<Album>)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sortAZ -> albumAdapter.sortByTitle()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.album_menu, menu)
        return true
    }


    override fun clicked(albumId: Int) {
        val intent = Intent(this, PhotoActivity::class.java)
        intent.putExtra(ALBUM_ID, albumId)
        startActivity(intent)
    }


}

interface AlbumClicked {
    fun clicked(albumId: Int)
}