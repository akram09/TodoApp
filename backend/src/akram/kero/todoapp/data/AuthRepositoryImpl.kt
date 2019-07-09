package akram.kero.todoapp.data

import akram.kero.todoapp.domain.AuthRepository
import akram.kero.todoapp.domain.UserPassword

class AuthRepositoryImpl:AuthRepository {
    override suspend fun validateUserBasicAuth(user: UserPassword): Boolean {
        return user.userName=="Hello World" && user.password=="Juju"
    }
}