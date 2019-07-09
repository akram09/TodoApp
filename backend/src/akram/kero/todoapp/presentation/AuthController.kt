package akram.kero.todoapp.presentation

import akram.kero.todoapp.domain.UserPassword
import akram.kero.todoapp.domain.ValidateBasicAuth
import com.auth0.jwt.interfaces.Payload
import io.ktor.auth.Principal
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.UserPasswordCredential
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.suspendCoroutine

class AuthController(private val basicAuthUseCase:ValidateBasicAuth) {
//    suspend fun validateJwtUser(payload: Payload) = coroutineScope<Boolean> {
//
//    }

    suspend fun validateBasicAuthUser(userPasswordCredential: UserPasswordCredential) = coroutineScope {
        val isAuthorized = async { basicAuthUseCase(UserPassword(userPasswordCredential.name , userPasswordCredential.password)) }
        if(isAuthorized.await()){
            UserIdPrincipal(userPasswordCredential.name)
        }else{
            null
        }
    }
}