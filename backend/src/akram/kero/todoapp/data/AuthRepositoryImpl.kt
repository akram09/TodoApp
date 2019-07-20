package akram.kero.todoapp.data

import akram.kero.todoapp.domain.failure.Failure
import akram.kero.todoapp.domain.interactors.*
import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.Either
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl: AuthRepository {
    override suspend fun validateUserBasicAuth(user: UserPassword): Boolean {
        return user.userName=="Hello World" && user.password=="Juju"
    }

    override fun configureJwtAuth(): Pair<Verifier, Validator> {
        val validator:suspend (String)->Boolean= {
           coroutineScope {
               delay(2000L)
               true
           }
        }
        return Pair(Verifier("ktor.io_issuer" , "Authentification" , "todo_app") ,validator)
    }

    override suspend fun signUpUser(user: SignUpParam): Either<Failure.SignUpFailure, Token> {
        // just to simulate a db query time elaapse
        delay(1000L)
        return Either.Right(Token(JwtConfig.makeToken("userId")))}
}