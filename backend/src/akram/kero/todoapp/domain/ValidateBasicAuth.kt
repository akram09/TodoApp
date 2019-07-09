package akram.kero.todoapp.domain

import akram.kero.todoapp.utils.CouroutineDispatchers
import akram.kero.todoapp.utils.Interactor

data class UserPassword(val userName:String , val password:String)
class ValidateBasicAuth(val repository: AuthRepository , dispatchers: CouroutineDispatchers)
                : Interactor<UserPassword , Boolean >(dispatchers) {

    override suspend fun invoke(executeParams: UserPassword): Boolean {
        return repository.validateUserBasicAuth(executeParams)
    }
}