package akram.kero.todoapp.domain

import org.koin.dsl.module

val domainModule= module {
     single {
         CoroutinesDispatcherImpl()
     }
    single {
        SignUpUser(get() , get())
    }
    single {
        ValidateBasicAuth(get() , get())
    }
}