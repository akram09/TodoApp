package com.kero.todo.common

fun <L , R  , NL , NR> Pair<L , R>.map(fnL: (L) -> NL , fnR:(R)->NR):Pair<NL , NR>{
    return   Pair(fnL(first) , fnR(second))
}
fun <L , R , NL> Either<L, R>.mapLeft(fnL:(L)->NL): Either<NL, R>
        =  when(this){
    is Either.Left-> Either.Left(fnL(a))
    is Either.Right ->  this
}