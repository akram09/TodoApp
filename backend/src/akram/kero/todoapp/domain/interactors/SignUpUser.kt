package akram.kero.todoapp.domain.interactors

import akram.kero.todoapp.domain.failure.Failure
import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.CouroutineDispatchers
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.EitherInteractor

data class SignUpParam(val email:String , val password:String)
data class Token(val key :String)
class SignUpUser (val repository: AuthRepository, dispatchers: CouroutineDispatchers)
                            :EitherInteractor<SignUpParam, Token, Failure.SignUpFailure >(dispatchers) {


    override suspend fun invoke(executeParams: SignUpParam): Either<Failure.SignUpFailure, Token> {
        return repository.signUpUser(executeParams)
    }
}