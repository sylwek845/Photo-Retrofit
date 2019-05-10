package com.example.albumretrofit.ui.album

import com.example.albumretrofit.R
import com.example.albumretrofit.base.BasePresenter
import com.example.albumretrofit.injection.api.AlbumApi
import com.example.albumretrofit.ui.ItemView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
class AlbumPresenter(album: ItemView) : BasePresenter<ItemView>(album) {
    @Inject
    lateinit var albumApi: AlbumApi


    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadAlbums()
    }

    /**
     * Loads the albums from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    private fun loadAlbums() {
        view.showLoading()
        subscription = albumApi
            .getAlbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { albumList -> view.updateItem(albumList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}