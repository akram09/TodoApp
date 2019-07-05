package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Components

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.AndroidApplication
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask.AddTaskBuilder
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks.TasksBuilder
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseFragment
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Modules.AppModule
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class
      , AndroidInjectionModule::class,
    TasksBuilder::class,
    AddTaskBuilder::class
    ])
interface AppComponent :AndroidInjector<AndroidApplication>{
    @Component.Builder
    abstract class Builder:AndroidInjector.Builder<AndroidApplication>()
}