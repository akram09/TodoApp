package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask

import android.util.Log
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.domain.interactors.AddTask
import oxxy.kero.roiaculte.team7.domain.interactors.launchInteractor
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseViewModel
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.State
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Async
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Event
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Uninitialized
import javax.inject.Inject

data class AddTaskState(val isLoading :Boolean , var task : Task, var taskAdded: Event<Boolean>):State

class AddTaskViewModel
@Inject constructor(val usecase: AddTask) :BaseViewModel<AddTaskState>(
    AddTaskState(
        false, Task(
            0,
            "", "", ""
        ), Event(false)
    )
)
    , AddTaskFragment.AddTaskCallback {
    override fun onAddBtnClicked(title: String, color: String, description: String) {
        setState {
            copy(task = task.copy(title = title, description = description, color = color))
        }
        withState {
            scope.launchInteractor(usecase, it.task) {
                setState { copy(taskAdded= Event(true)) }
            }
        }
    }

}
