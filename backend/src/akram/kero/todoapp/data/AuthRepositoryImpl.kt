package akram.kero.todoapp.data

import akram.kero.todoapp.domain.*
import akram.kero.todoapp.presentation.JwtConfig
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.None
import kotlinx.coroutines.delay

class AuthRepositoryImpl:AuthRepository {
    override suspend fun validateUserBasicAuth(user: UserPassword): Boolean {
        return user.userName=="Hello World" && user.password=="Juju"
    }

    override suspend fun signUpUser(user: SignUpParam): Either<Failure.SignUpFailure, Token> {
        // just to simulate a db query time elaapse
        delay(1000L)
        return Either.Right(Token(JwtConfig.makeToken("userId")))}
}