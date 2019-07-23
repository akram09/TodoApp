package akram.kero.todoapp.domain.failure

sealed class Failure{
    sealed class SignUpFailure: Failure(){
        object UserAlreadySigned:SignUpFailure()
    }
}