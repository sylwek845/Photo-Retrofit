package com.example.albumretrofit.injection.components

import com.example.albumretrofit.base.BaseView
import com.example.albumretrofit.injection.module.ContextModule
import com.example.albumretrofit.injection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Sylwek on 10/05/2019.
 * AlbumRetrofit
 */
/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     *
     */
   //TODO Injects

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}