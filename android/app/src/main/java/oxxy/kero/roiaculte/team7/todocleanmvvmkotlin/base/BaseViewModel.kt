package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.Either
import oxxy.kero.roiaculte.team7.domain.interactors.ObservableInteractor

abstract  class BaseViewModel<S:State>(initialState:S): ViewModel() {
    protected val state:MutableLiveData<S> by lazy {
       var liveData:MutableLiveData<S> = MutableLiveData()
        liveData.value=initialState
        liveData
    }
   private val job = Job()
    protected val scope  = CoroutineScope(Dispatchers.Main+job)
     private  val disposable:CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if(job.isActive){
            job.cancel()
        }
        disposable.dispose()
    }
    protected fun setState( statechenger :S.()->S){
        state.value = state.value?.statechenger()
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer : ((s:S)->Unit))
    {
        state.observe(lifecycleOwner, Observer(observer))
    }
    fun withState(chenger :(s:S)->Unit){
        chenger(state.value!!)
    }
    protected fun  <P, Type> launchObservableInteractor(interactor:ObservableInteractor<Type, P>
                                                        , p:P, errorHandler :(f: Failure)->Unit
                                                        , dataHandler:(t:Type)->Unit){
       disposable.add(interactor.observe(p){
           it.either(
               {
                   errorHandler(it)
               }, {
                   dataHandler(it)
               }
           )
       })
    }


}

