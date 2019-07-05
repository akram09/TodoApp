package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base

import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.AndroidApplication
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Components.AppComponent
import javax.inject.Inject

open class BaseFragment :DaggerFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
     interface BaseCallBack
}