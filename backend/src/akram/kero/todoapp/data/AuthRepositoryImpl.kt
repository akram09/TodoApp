package akram.kero.todoapp.data

import akram.kero.todoapp.data.database_models.User
import akram.kero.todoapp.domain.failure.Failure
import akram.kero.todoapp.domain.interactors.*
import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.None
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.experimental.builder.create
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl(hikariDataSource: HikariDataSource): AuthRepository {
    init {
        Database.connect(hikariDataSource)
        transaction {
            SchemaUtils.create(User)
        }
    }
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
        val users = transaction {
             User.select{
                User.email eq user.email
            }.toList()
        }
        return if(users.isEmpty()){
               val id = transaction {
                    User.insert {
                        it[email] = user.email
                        it[password] = user.password
                    }
                   User.select{
                       User.email  eq  user.email
                   }.toList()[0]

                  }

                     Either.Right(Token(JwtConfig.makeToken(id[User.uuid].toString())))
                }else{
                        Either.Left(Failure.SignUpFailure.UserAlreadySigned)
                }

        }


    private suspend fun signUpUser(email:String , password:String):String?  = coroutineScope{
        if(isUserInDatabase(email)){



            ""
        }else{
            null
        }


    }
    private suspend fun isUserInDatabase(email: String):Boolean = suspendCoroutine {
            val  users  = transaction {
                User.select {
                    User.email eq email
                }.toList()
            }
        it.resume(users.isEmpty())
    }
    private suspend fun createUser(email:String , password: String):User = suspendCoroutine {

    }


}