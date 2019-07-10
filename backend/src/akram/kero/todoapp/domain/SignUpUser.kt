package akram.kero.todoapp.domain

import akram.kero.todoapp.utils.CouroutineDispatchers
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.EitherInteractor
import akram.kero.todoapp.utils.None

data class SignUpParam(val email:String  , val password:String)
data class Id(val value:String)
class SignUpUser (val repository: AuthRepository , dispatchers: CouroutineDispatchers)
                            :EitherInteractor<SignUpParam, Id,Failure.SignUpFailure >(dispatchers) {


    override suspend fun invoke(executeParams: SignUpParam): Either<Failure.SignUpFailure, Id> {
        return repository.signUpUser(executeParams)
    }
}