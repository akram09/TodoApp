package akram.kero.todoapp.presentation.auth

import akram.kero.todoapp.domain.*
import akram.kero.todoapp.presentation.views_model.ErrorReporting
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.launchInteractor
import akram.kero.todoapp.utils.map
import akram.kero.todoapp.utils.mapLeft
import com.auth0.jwt.interfaces.Payload
import io.ktor.auth.Principal
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.UserPasswordCredential
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.suspendCoroutine

class AuthController(private val basicAuthUseCase:ValidateBasicAuth , val signUpUseCase:SignUpUser) {

    suspend fun signUpUser(signUpParam: SignUpParam):Either<ErrorReporting  , Token>{
        val either =  launchInteractor(signUpUseCase , signUpParam)
        return either.mapLeft{
            ErrorReporting(arrayOf())
        }
    }

    suspend fun validateBasicAuthUser(userPasswordCredential: UserPasswordCredential) : UserIdPrincipal? {
        val isAuthorized =  launchInteractor(basicAuthUseCase, UserPassword(userPasswordCredential.name , userPasswordCredential.password))
       return  if(isAuthorized){
            UserIdPrincipal(userPasswordCredential.name)
        }else{
            null
        }
    }
}