package akram.kero.todoapp.presentation

import io.ktor.auth.Principal


data class User (val mail :String , val password:String ):Principal