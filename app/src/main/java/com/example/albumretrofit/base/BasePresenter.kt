package com.example.albumretrofit.base

import com.example.albumretrofit.injection.components.DaggerPresenterInjector
import com.example.albumretrofit.injection.components.PresenterInjector
import com.example.albumretrofit.injection.module.ContextModule
import com.example.albumretrofit.injection.module.NetworkModule
import com.example.albumretrofit.ui.album.AlbumPresenter
import com.example.albumretrofit.ui.photo.PhotoPresenter

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}
    open fun onViewCreated(albumId:Int){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is AlbumPresenter -> injector.inject(this)
            is PhotoPresenter -> injector.inject(this)
        }
    }
}