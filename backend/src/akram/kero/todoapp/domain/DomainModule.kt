package akram.kero.todoapp.domain

import akram.kero.todoapp.domain.interactors.ConfigureBasicAuth
import akram.kero.todoapp.domain.interactors.ConfigureJwtAuth
import akram.kero.todoapp.domain.interactors.SignUpUser
import akram.kero.todoapp.utils.CouroutineDispatchers
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule= module {
     single {
         CoroutinesDispatcherImpl()
     } bind  CouroutineDispatchers::class
    single {
        SignUpUser(get(), get())
    }
    single {
        ConfigureBasicAuth(get(), get())
    }
    single{
        ConfigureJwtAuth(get())
    }
}