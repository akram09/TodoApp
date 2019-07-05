package oxxy.kero.roiaculte.team7.domain.interactors

import kotlinx.coroutines.CoroutineDispatcher
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.CouroutineDispatchers
import oxxy.kero.roiaculte.team7.domain.functional.Either
import oxxy.kero.roiaculte.team7.domain.repositories.TasksRepository
import javax.inject.Inject

class AddTask @Inject constructor(dispatchers:CouroutineDispatchers,
                            private val repository:TasksRepository) :Interactor<Task>{
    override val dispatcher=dispatchers.io
    override val ResultDispatcher = dispatchers.main

    override suspend fun invoke(executeParams: Task){
         repository.addTask(executeParams)
    }
}