package oxxy.kero.roiaculte.team7.domain.repositories

import io.reactivex.Observable
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.Either


interface TasksRepository {
    fun observeTasks(): Observable<List<Task>>
    suspend fun  addTask( task:Task)
}