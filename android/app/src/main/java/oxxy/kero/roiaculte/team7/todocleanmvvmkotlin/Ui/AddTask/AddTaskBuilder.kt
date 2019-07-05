package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask

import dagger.Module
import dagger.android.ContributesAndroidInjector
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.ViewModelModule

@Module
abstract class AddTaskBuilder {
    @ContributesAndroidInjector(
        modules = [AddTaskModule::class,
                ViewModelModule::class,
        FragmentBuilder::class]
    )
    abstract fun provideActivity(): AddTasksActivity




}