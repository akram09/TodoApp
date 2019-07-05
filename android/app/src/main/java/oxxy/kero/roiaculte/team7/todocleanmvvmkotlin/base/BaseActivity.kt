package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Components.DaggerAppComponent

abstract class BaseActivity :DaggerAppCompatActivity(){

    abstract fun fragment(): BaseFragment
}