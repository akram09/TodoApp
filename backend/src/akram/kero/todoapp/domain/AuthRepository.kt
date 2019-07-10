package akram.kero.todoapp.domain

import akram.kero.todoapp.utils.Either
import akram.kero.todoapp.utils.None

interface AuthRepository {
    suspend fun validateUserBasicAuth(user:UserPassword):Boolean
    suspend fun signUpUser(user:SignUpParam):Either<Failure.SignUpFailure , Id>
}