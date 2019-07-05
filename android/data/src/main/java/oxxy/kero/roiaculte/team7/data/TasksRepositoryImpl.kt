package oxxy.kero.roiaculte.team7.data

import io.reactivex.Observable
import oxxy.kero.roiaculte.team7.data.entities.TasksDatabase
import oxxy.kero.roiaculte.team7.data.entities.map
import oxxy.kero.roiaculte.team7.data.entities.mapTo
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.Either
import oxxy.kero.roiaculte.team7.domain.repositories.TasksRepository
import java.lang.Exception

class TasksRepositoryImpl(val tasksDatabase: TasksDatabase) :TasksRepository {
    private val daos = tasksDatabase.tasksDao()
    override fun observeTasks(): Observable<List<Task>> {
        return daos.getTasks().toObservable().map {
            it.map { taskEntity ->
                mapTo(taskEntity)
            }
        }
    }

    override suspend fun addTask(task: Task) {
        daos.addTask(map(task))
    }
}