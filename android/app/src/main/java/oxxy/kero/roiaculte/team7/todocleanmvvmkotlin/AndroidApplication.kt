package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Components.AppComponent
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Components.DaggerAppComponent
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Modules.AppModule


class AndroidApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return  DaggerAppComponent.builder().create(this)
    }
}