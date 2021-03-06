package com.kero.todo.common.failure

sealed class Failure{
    sealed class SignUpFailure: Failure(){
        object UserAlreadySigned: SignUpFailure()
    }

    sealed class LoginFailure: Failure(){
        object UserNotFound: LoginFailure()
        object PasswordIncorrect: LoginFailure()
    }
}