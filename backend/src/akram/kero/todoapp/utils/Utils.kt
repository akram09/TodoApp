package akram.kero.todoapp.utils

import io.ktor.application.ApplicationCallPipeline
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.suspendCoroutine

fun <L , R , NL>Either<L , R>.mapLeft(fnL:(L)->NL):Either<NL , R>
   =  when(this){
        is Either.Left-> Either.Left(fnL(a))
        is Either.Right ->  this
    }
suspend fun <L:Any , R:Any>Either<L , R>.responde( respond: suspend (status:HttpStatusCode, message:Any )->Unit)  {
    when(this){
        is Either.Left -> respond( HttpStatusCode.OK , a)
        is Either.Right -> respond( HttpStatusCode.OK, b)
    }
}

