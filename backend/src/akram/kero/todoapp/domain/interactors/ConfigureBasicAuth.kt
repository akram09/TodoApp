package akram.kero.todoapp.domain.interactors

import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.CouroutineDispatchers
import akram.kero.todoapp.utils.Interactor

data class UserPassword(val userName:String , val password:String)
class ConfigureBasicAuth(private val repository: AuthRepository, dispatchers: CouroutineDispatchers)
                : Interactor<UserPassword, Boolean >(dispatchers) {

    override suspend fun invoke(executeParams: UserPassword): Boolean {
        return repository.validateUserBasicAuth(executeParams)
    }
}