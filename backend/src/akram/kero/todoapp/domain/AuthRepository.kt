package akram.kero.todoapp.domain

interface AuthRepository {
    suspend fun validateUserBasicAuth(user:UserPassword):Boolean
}