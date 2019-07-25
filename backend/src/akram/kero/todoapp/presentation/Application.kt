package akram.kero.todoapp.presentation

import akram.kero.todoapp.data.JwtConfig
import akram.kero.todoapp.data.dataModule
import akram.kero.todoapp.domain.*
import akram.kero.todoapp.domain.interactors.SignUpParam
import akram.kero.todoapp.presentation.auth.AuthController
import akram.kero.todoapp.presentation.auth.authModule
import akram.kero.todoapp.utils.responde
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.auth.basic
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.request.*
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.core.context.startKoin
import org.koin.ktor.ext.inject
import org.slf4j.event.Level
import java.text.DateFormat


fun main(args:Array<String>){
    startKoin {
        printLogger()
        modules(listOf(domainModule , dataModule , authModule))
    }
    embeddedServer(Netty , commandLineEnvironment(args) ).start()
}

fun Application.module(){
     val controller:AuthController by inject()

    install(CallLogging){
        level = Level.DEBUG
    }
    install(ContentNegotiation){
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }
    install(DefaultHeaders)
    install(Authentication){

        basic("Basic-Auth"){
            realm = "todo.ktor.io.basic"
            validate {
                controller.handleBasicAuth(it)
            }
        }
        jwt("Jwt-Auth") {
            realm ="todo_ktor.io"
            val result =controller.handleJWtAuth()
            verifier(result.first)
            validate {
                result.second(it)
            }
        }
    }
    routing {

        authenticate("Basic-Auth") {
            get("/auth/login") {
                val user = call.receive(SignUpParam::class)
                controller.loginUser(user)
            }
            post("/auth/signUp"){
                val user = call.receive(SignUpParam::class)
                controller.signUpUser(user).responde(call::respond)
            }
        }
        authenticate("Jwt-Auth") {
            get("/api/hello"){
                log.debug(call.receiveText())
                call.respond("hello world")
            }
        }


    }



}


