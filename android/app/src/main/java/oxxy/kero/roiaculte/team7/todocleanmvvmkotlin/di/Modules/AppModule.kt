package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.di.Modules

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import oxxy.kero.roiaculte.team7.data.TasksRepositoryImpl
import oxxy.kero.roiaculte.team7.data.entities.TasksDatabase
import oxxy.kero.roiaculte.team7.domain.functional.AppRxSchedulers
import oxxy.kero.roiaculte.team7.domain.functional.CouroutineDispatchers
import oxxy.kero.roiaculte.team7.domain.repositories.TasksRepository
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.AndroidApplication
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Schedulers.AppCoroutineDispatchers
import javax.inject.Singleton

@Module
class AppModule{
    @Provides fun provideContext(application: AndroidApplication):Context{
         return application.applicationContext
     }
    @Provides @Singleton
    fun provideDatabase(context :Context ):TasksDatabase{
        return TasksDatabase.create(context)
    }
    @Provides fun provideSchedulers():AppRxSchedulers{
        return oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Schedulers.AppRxSchedulers(Schedulers.io()
            , AndroidSchedulers.mainThread(), Schedulers.computation())
    }
    @Provides fun provideDispatchers(): CouroutineDispatchers{
        return AppCoroutineDispatchers(Dispatchers.IO, Dispatchers.Unconfined, Dispatchers.Main)
    }
    @Provides fun provideTaskRepository(tasksDatabase: TasksDatabase):TasksRepository{
        return TasksRepositoryImpl(tasksDatabase)
    }

}
