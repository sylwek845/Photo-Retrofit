package com.example.albumretrofit.ui.photo

import com.example.albumretrofit.R
import com.example.albumretrofit.base.BasePresenter
import com.example.albumretrofit.injection.api.PhotoApi
import com.example.albumretrofit.ui.ItemView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
class PhotoPresenter(photo: ItemView) : BasePresenter<ItemView>(photo) {
    @Inject
    lateinit var photoApi: PhotoApi

    private var subscription: Disposable? = null

    override fun onViewCreated(albumId: Int) {
        loadAlbums(albumId)
    }


    /**
     * Loads the posts from the API and presents them in the view when retrieved, or showss error if
     * any.
     */
    private fun loadAlbums(albumId: Int) {
        view.showLoading()
        subscription = photoApi
            .getPhotos(albumId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { photoList -> view.updateItem(photoList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}

