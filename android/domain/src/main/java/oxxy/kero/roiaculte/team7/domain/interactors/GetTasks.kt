package oxxy.kero.roiaculte.team7.domain.interactors

import io.reactivex.Observable
import oxxy.kero.roiaculte.team7.domain.repositories.TasksRepository
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.AppRxSchedulers
import oxxy.kero.roiaculte.team7.domain.functional.CouroutineDispatchers
import oxxy.kero.roiaculte.team7.domain.functional.Either
import javax.inject.Inject
 typealias  Tasks= List<Task>
class GetTasks
@Inject constructor(private val   repository: TasksRepository,
                    schedulers: AppRxSchedulers):ObservableInteractor<Tasks, None>(schedulers) {

    override fun buildObservable(p: None): Observable<Tasks> {
        return repository.observeTasks()
    }

}