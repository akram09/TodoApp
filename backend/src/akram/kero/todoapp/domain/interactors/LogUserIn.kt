package akram.kero.todoapp.domain.interactors

import akram.kero.todoapp.domain.failure.Failure
import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.CouroutineDispatchers
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.EitherInteractor

class LogUserIn(private val repository: AuthRepository , dispatchers: CouroutineDispatchers)
            :EitherInteractor<SignUpParam , Token,Failure.LoginFailure>(dispatchers) {

    override suspend fun invoke(executeParams: SignUpParam): Either<Failure.LoginFailure, Token> {
        return repository.loginUser(executeParams)
    }
}