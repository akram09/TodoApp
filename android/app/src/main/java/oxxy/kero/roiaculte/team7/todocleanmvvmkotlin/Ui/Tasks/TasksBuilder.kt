package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import dagger.Module
import dagger.android.ContributesAndroidInjector
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.ViewModelModule

@Module
abstract class TasksBuilder {
    @ContributesAndroidInjector(
        modules = [
        ViewModelModule::class,
            TasksModule::class,
        FragmentBuilder::class
        ]
    )
    abstract fun provideTasksACtivity():TasksActivity
}