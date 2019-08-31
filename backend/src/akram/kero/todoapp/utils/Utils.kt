package akram.kero.todoapp.utils

import io.ktor.application.ApplicationCallPipeline
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.suspendCoroutine

suspend fun <L:Any , R:Any>Either<L , R>.responde( respond: suspend (status:HttpStatusCode, message:Any )->Unit)  {
    when(this){
        is Either.Left -> respond( HttpStatusCode.OK , a)
        is Either.Right -> respond( HttpStatusCode.OK, b)
    }
}


