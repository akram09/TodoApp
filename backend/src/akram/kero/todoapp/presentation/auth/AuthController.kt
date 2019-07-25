package akram.kero.todoapp.presentation.auth

import akram.kero.todoapp.data.JwtConfig
import akram.kero.todoapp.domain.interactors.*
import akram.kero.todoapp.presentation.views_model.ErrorReporting
import akram.kero.todoapp.utils.*
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.UserPasswordCredential
import io.ktor.auth.jwt.JWTCredential
import io.ktor.auth.jwt.JWTPrincipal
import kotlinx.coroutines.coroutineScope

class AuthController(private val basicAuthUseCase: ConfigureBasicAuth
                     ,private  val signUpUseCase: SignUpUser
                     ,private val jwtAuth: ConfigureJwtAuth
                      , private val logUserIn: LogUserIn  ) {

    suspend fun signUpUser(signUpParam: SignUpParam):Either<ErrorReporting  , Token>{
        val either =  launchInteractor(signUpUseCase , signUpParam)
        return either.mapLeft{
            ErrorReporting(arrayOf())
        }
    }
    fun handleJWtAuth(): Pair< JWTVerifier, suspend (JWTCredential)->JWTPrincipal?>{
            val result = jwtAuth(None())
        val jwtVerifier = JWT.require(Algorithm.HMAC256(result.first.algorithme))
            .withIssuer(result.first.issuer)
            .withSubject(result.first.subject)
            .build()
        val function :suspend (JWTCredential)->JWTPrincipal? = {
            coroutineScope {
                if(result.second(it.payload.getClaim("UserId").asString())){
                    JWTPrincipal(it.payload)
                }else{
                    null
                }
            }
        }
        return Pair(jwtVerifier , function)
    }

    suspend fun loginUser(signUpParam: SignUpParam):Either<ErrorReporting , Token>{
        val either = launchInteractor(logUserIn , signUpParam)
        return either.mapLeft {
            ErrorReporting(arrayOf())
        }
    }

    suspend fun handleBasicAuth(userPasswordCredential: UserPasswordCredential) : UserIdPrincipal? {
        val isAuthorized =  launchInteractor(basicAuthUseCase,
            UserPassword(
                userPasswordCredential.name,
                userPasswordCredential.password
            )
        )
       return  if(isAuthorized){
            UserIdPrincipal(userPasswordCredential.name)
        }else{
            null
        }
    }
}