package com.example.albumretrofit.base

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {

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
           //TODO
        }
    }
}