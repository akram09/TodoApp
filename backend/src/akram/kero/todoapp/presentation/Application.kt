package akram.kero.todoapp.presentation

import akram.kero.todoapp.data.AuthRepositoryImpl
import akram.kero.todoapp.domain.CoroutinesDispatcherImpl
import akram.kero.todoapp.domain.ValidateBasicAuth
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.auth.Authentication
import io.ktor.auth.UserPasswordCredential
import io.ktor.auth.authenticate
import io.ktor.auth.basic
import io.ktor.auth.jwt.jwt
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.ApplicationEngineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.EngineMain
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import org.slf4j.event.Level


fun main(args:Array<String>){
    EngineMain.main(args)
}

fun Application.module(){
     val controller = AuthController(ValidateBasicAuth(AuthRepositoryImpl(), CoroutinesDispatcherImpl()))
    install(CallLogging){
        level = Level.DEBUG
    }
    install(DefaultHeaders)

    install(Authentication){
        jwt("Jwt-Auth") {
            realm ="todo_ktor.io"
            verifier(JwtConfig.jwtVerifier)
//            validate{
//
//            }
        }
        basic("Basic-Auth"){
            realm = "todo.ktor.io.basic"
            validate {
                controller.validateBasicAuthUser(it)
            }
        }
    }
    routing {

        authenticate("Basic-Auth") {

            get("/login") {
                call.respond("Hello World !!!!!")
            }
        }

    }

}
