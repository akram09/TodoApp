package akram.kero.todoapp.utils

import akram.kero.todoapp.domain.Failure
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.*


abstract class ObservableEitherInteractor<R , in P , F: Failure>(private val schedulers: AppRxSchedulers){
    protected abstract fun buildObservable(p:P): Observable<Either<F, R>>

    fun observe(p : P , handler : (Either<F, R>) -> Unit ) : Disposable {
        return  buildObservable(p).subscribeOn(schedulers.io).observeOn(schedulers.main)
            .subscribe(handler)
    }
}

/**
 * interactor runs in background Couroutine and return
 * either result or Failure
 * */

abstract class EitherInteractor<in P, out R , out F : Failure>(dispatcher: CouroutineDispatchers) {
    val dispatcher: CoroutineDispatcher = dispatcher.io
    val resultDispatcher :CoroutineDispatcher = dispatcher.main
    abstract suspend operator fun invoke(executeParams: P): Either<F, R>
}


/**
 * interactor runs in background Couroutine and return result
 * this interctore is used in cases where there is no possible failures
 * */

abstract class Interactor<in P , out R >(dispatcher: CouroutineDispatchers){
    val dispatcher: CoroutineDispatcher = dispatcher.io
    val resultDispatcher : CoroutineDispatcher = dispatcher.main
    abstract suspend operator fun invoke(executeParams: P):R
}


/**
 * interctore runs in background thread and return a stream
 * of values of type @param Type
 * this interactor is used like a normal observable
 * */

abstract class ObservableInteractor<Type , in Params>(private val schedulers:AppRxSchedulers){

    protected abstract fun buildObservable(p:Params):Observable< Type>

    fun observe(p:Params, FailureObserver:(e:Throwable)->Unit , SuccesObserver:(t:Type)->Unit): Disposable {
        return buildObservable(p).subscribeOn(schedulers.io).observeOn(schedulers.main)
            .subscribe(SuccesObserver, FailureObserver)
    }
}

/**
 * an extension  function to launch Either Interactor
 * frome viewModel scope
 * */

suspend fun <P, R, T:Failure> launchInteractor(interactor: EitherInteractor<P, R, T>, param: P) = coroutineScope{

    val  job = async(interactor.dispatcher) { interactor(param) }
     job.await()
}


/**
 * an extension  function to launch simple Interactor
 * frome viewModel scope
 * */

suspend fun <P , R> launchInteractor(interactor: Interactor<P, R>, param: P) = coroutineScope{
    val job = async(context = interactor.dispatcher){interactor(param)}
     job.await()
}



/**
 * this classe mean no parametre will be supplied to interactors
 * or no result  waited by interactor
 * */

class None