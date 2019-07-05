package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.viewmodel.ViewModelKey

@Module
abstract class FragmentBuilder {

   @ContributesAndroidInjector
   abstract fun provideTasksFragment():TasksFragment

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    abstract fun bindsMoviesViewModel(tasksViewModel: TasksViewModel): ViewModel

}