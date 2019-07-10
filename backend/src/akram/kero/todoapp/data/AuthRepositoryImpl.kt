package akram.kero.todoapp.data

import akram.kero.todoapp.domain.*
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.None
import kotlinx.coroutines.delay

class AuthRepositoryImpl:AuthRepository {
    override suspend fun validateUserBasicAuth(user: UserPassword): Boolean {
        return user.userName=="Hello World" && user.password=="Juju"
    }

    override suspend fun signUpUser(user: SignUpParam): Either<Failure.SignUpFailure, Id> {
        delay(1000L)
        return Either.Right(Id("hello WORLD"))
    }
}