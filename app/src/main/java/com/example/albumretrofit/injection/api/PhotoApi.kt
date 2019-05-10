package com.example.albumretrofit.injection.api

import com.example.albumretrofit.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
interface PhotoApi {
    @GET("/photos")
    fun getPhotos(): Observable<List<Photo>>

    @GET("/photos")
    fun getPhotos(@Query("albumId") id: Int): Observable<List<Photo>>
}