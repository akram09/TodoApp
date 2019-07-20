package akram.kero.todoapp.data

import akram.kero.todoapp.domain.repositories.AuthRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        AuthRepositoryImpl()
    }  bind  AuthRepository::class
}