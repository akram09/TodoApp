package akram.kero.todoapp.utils

import kotlinx.coroutines.CoroutineDispatcher

interface CouroutineDispatchers {
    val io:CoroutineDispatcher
    val main:CoroutineDispatcher
    val computaion :CoroutineDispatcher
}