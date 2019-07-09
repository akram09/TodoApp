package akram.kero.todoapp.domain

import akram.kero.todoapp.utils.CouroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutinesDispatcherImpl:CouroutineDispatchers {
    override val io = Dispatchers.IO
    override val main = Dispatchers.Main
    override val computaion = Dispatchers.Default
}