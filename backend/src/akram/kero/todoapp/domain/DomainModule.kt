package akram.kero.todoapp.domain

import akram.kero.todoapp.utils.CouroutineDispatchers
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule= module {
     single {
         CoroutinesDispatcherImpl()
     } bind  CouroutineDispatchers::class
    single {
        SignUpUser(get() , get())
    }
    single {
        ValidateBasicAuth(get() , get())
    }
}