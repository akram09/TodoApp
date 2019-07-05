package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.State
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Async
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Uninitialized

data class TasksState(val isLoading :Boolean,
                      var tasks : Async<List<Task>> = Uninitialized
                      ) : State
