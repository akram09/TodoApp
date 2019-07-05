package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Schedulers

import io.reactivex.Scheduler
import oxxy.kero.roiaculte.team7.domain.functional.AppRxSchedulers

data class AppRxSchedulers(override val io :Scheduler, override val main:Scheduler, override val computation:Scheduler ):
    AppRxSchedulers