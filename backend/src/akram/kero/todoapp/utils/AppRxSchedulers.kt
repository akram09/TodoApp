package akram.kero.todoapp.utils

import io.reactivex.Scheduler

interface AppRxSchedulers {
     val io : Scheduler
     val main :Scheduler
    val computation:Scheduler
}