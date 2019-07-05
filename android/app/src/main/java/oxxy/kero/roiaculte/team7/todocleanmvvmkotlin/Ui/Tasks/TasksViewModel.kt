package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import android.util.Log
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.interactors.GetTasks
import oxxy.kero.roiaculte.team7.domain.interactors.None
import oxxy.kero.roiaculte.team7.domain.interactors.Tasks
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseViewModel
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Success
import javax.inject.Inject

class TasksViewModel
@Inject constructor(useCase : GetTasks) : BaseViewModel<TasksState>(
    TasksState(true)
) {

    init {
       launchObservableInteractor(useCase,None(), ::handleFailure,::handleTasks )
    }
    private fun handleFailure(it: Failure){
//       setState {
//           copy(isLoading = false, tasks = Fail(it))
//       }
    }
    private fun handleTasks(it:Tasks){
        setState {  copy(isLoading = false, tasks =  Success(it))}
        Log.e("errr", "hellosss ${it.size}")
        Log.e("errr", "${state.hasActiveObservers()}")
    }
}