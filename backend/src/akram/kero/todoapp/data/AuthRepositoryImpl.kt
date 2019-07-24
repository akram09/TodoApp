package akram.kero.todoapp.data

import akram.kero.todoapp.data.database_models.UserTable
import akram.kero.todoapp.domain.failure.Failure
import akram.kero.todoapp.domain.interactors.*
import akram.kero.todoapp.domain.models.User
import akram.kero.todoapp.domain.repositories.AuthRepository
import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.None
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateStatement
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.experimental.builder.create
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl(hikariDataSource: HikariDataSource): AuthRepository {
    init {
        Database.connect(hikariDataSource)
        transaction {
            SchemaUtils.create(UserTable)
        }
    }



    override suspend fun validateUserBasicAuth(user: UserPassword): Boolean {
        return user.userName=="Hello World" && user.password=="Juju"
    }




    override fun configureJwtAuth(): Pair<Verifier, Validator> {
        val validator:suspend (String)->Boolean= {
           coroutineScope {
               !getUseByUUid(UUID.fromString(it)).isEmpty()
           }
        }
        return Pair(Verifier("ktor.io_issuer" , "Authentification" , "todo_app") ,validator)
    }
    private suspend  fun getUseByUUid(uuid: UUID) :List<User> = suspendCoroutine{
       val user = transaction {
           UserTable.select{
               UserTable.uuid eq uuid
           }.toList()
       }
        it.resume(user.mapToUserList())
    }



    override suspend fun signUpUser(user: SignUpParam): Either<Failure.SignUpFailure, Token>
            = insertUserGetToken(user.email , user.password)?.let {
                    Either.Right(Token(JwtConfig.makeToken(it)))
                }   ?: Either.Left(Failure.SignUpFailure.UserAlreadySigned)





    private suspend fun insertUserGetToken(email:String , password:String):String?  = coroutineScope{
        if(isUserInDatabase(email)){
            createUser(email, password).toString()
        }else{
            null
        }


    }
    private suspend fun isUserInDatabase(email: String):Boolean {
        return getUsersByEmail(email).isEmpty()
    }

    private suspend fun createUser(email:String , password: String): UUID {
        insertUser(email , password)
        val id = getUserId(email)
        val uuid =UUID.randomUUID()
        updateUUID(id , uuid)
        return uuid
    }
    private suspend fun insertUser(email:String , password: String)= suspendCoroutine<Unit>{
         transaction {
             UserTable.insert {
                 it[UserTable.email] = email
                 it[UserTable.password] = password
             }
         }
        it.resume(Unit)
    }
    private suspend fun getUserId(email: String) :Int= coroutineScope {
         val users = getUsersByEmail(email)
         users[0].id
    }
    private suspend fun updateUUID(id:Int , uuid: UUID) = suspendCoroutine<Unit> {
        transaction {
            UserTable.update({
                UserTable.id eq id
            }) {
                it.set(UserTable.uuid, uuid)
            }
            it.resume(Unit)
        }
    }

    private suspend fun getUsersByEmail(email: String):List<User> = suspendCoroutine {
        val list  =transaction {
            UserTable.select {
                UserTable.email eq email
            }.toList()
        }
        it.resume(list.mapToUserList())
    }
    private fun List<ResultRow>.mapToUserList()
       = map { User(it[UserTable.id] , it[UserTable.email] , it[UserTable.password]) }





}