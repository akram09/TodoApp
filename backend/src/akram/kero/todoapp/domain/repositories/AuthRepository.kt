package akram.kero.todoapp.domain.repositories

import akram.kero.todoapp.domain.failure.Failure
import akram.kero.todoapp.domain.interactors.*
import akram.kero.todoapp.utils.Either

interface AuthRepository {
    suspend fun validateUserBasicAuth(user: UserPassword):Boolean
    suspend fun signUpUser(user: SignUpParam):Either<Failure.SignUpFailure , Token>
    fun configureJwtAuth():Pair<Verifier , Validator>
}