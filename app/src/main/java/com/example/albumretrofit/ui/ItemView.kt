package com.example.albumretrofit.ui

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */


import android.support.annotation.StringRes
import com.example.albumretrofit.base.BaseView

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
interface ItemView : BaseView {
    /**
     * Updates the previous item by the specified ones
     * @param items
     */
    fun updateItem(items: List<*>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }


    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}
