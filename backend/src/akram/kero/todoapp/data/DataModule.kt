package akram.kero.todoapp.data

import akram.kero.todoapp.domain.repositories.AuthRepository
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        AuthRepositoryImpl(get())
    }  bind  AuthRepository::class
    single{
        val config  = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:mem:test"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        HikariDataSource(config)
    }
}