package com.kero.akram.todo

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.JacksonConverter
import io.ktor.jackson.jackson

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation){
        jackson{
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
     }
    install(Authentication){
        basic("basicAuth"){
            realm="ktor"
            validate {
                if(it.name=="Akram" && it.password=="Conditional_Head") UserIdPrincipal(it.name) else null
            }
        }
    }

    routing {
        authenticate("basicAuth") {
            get("/") {
                call.respond(Person("hello", "hey "))
            }

        }


    }
}
data class Person(val name:String , val prenam:String)

