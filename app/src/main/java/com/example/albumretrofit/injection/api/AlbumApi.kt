package com.example.albumretrofit.injection.api

import com.example.albumretrofit.model.Album
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
interface AlbumApi {
    @GET("/albums")
    fun getAlbums(): Observable<List<Album>>

}