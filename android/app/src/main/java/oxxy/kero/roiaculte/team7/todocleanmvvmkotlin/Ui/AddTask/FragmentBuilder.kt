package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks.TasksViewModel
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.viewmodel.ViewModelKey

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun  provideFragment():AddTaskFragment

    @Binds
    @IntoMap
    @ViewModelKey(AddTaskViewModel::class)
    abstract fun bindsMoviesViewModel(tasksViewModel: AddTaskViewModel): ViewModel
}