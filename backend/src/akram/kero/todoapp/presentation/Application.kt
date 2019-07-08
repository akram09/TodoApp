package akram.kero.todoapp.presentation

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.jwt.jwt
import io.ktor.features.CallLogging
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

    install(CallLogging){
        level = Level.DEBUG
    }
    install(Authentication){
        jwt {
            realm ="todo_ktor.io"
            verifier(JwtConfig.jwtVerifier)
//            validate {
//            validate that the passed userId is in the database
//            }

        }
    }

}
