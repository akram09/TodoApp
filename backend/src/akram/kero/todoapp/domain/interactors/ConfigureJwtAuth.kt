package akram.kero.todoapp.domain.interactors

import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.CouroutineDispatchers
import akram.kero.todoapp.utils.Interactor
import akram.kero.todoapp.utils.None
import akram.kero.todoapp.utils.SyncInteractor

data class Verifier(val issuer:String ,val subject :String , val algorithme:String )
typealias Validator= suspend (String )->Boolean
class ConfigureJwtAuth (private val repository: AuthRepository)
                    :SyncInteractor<None , Pair<Verifier ,Validator > >(){


    override  fun invoke(executeParams: None): Pair<Verifier, Validator> {
        return repository.configureJwtAuth()
    }
}