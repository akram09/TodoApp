package akram.kero.todoapp.presentation.auth

import org.koin.dsl.module

val authModule = module {
       single {
           AuthController(get(), get() , get() , get())
       }
}