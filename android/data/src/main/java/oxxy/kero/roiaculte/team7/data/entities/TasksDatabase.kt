package oxxy.kero.roiaculte.team7.data.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
@Database(entities =[ TaskEntity::class], version = 1, exportSchema = false)
abstract class TasksDatabase :RoomDatabase(){
       abstract fun tasksDao():TasksDaos
    companion object {

        fun create(context: Context):TasksDatabase{
            return  databaseBuilder(context ,TasksDatabase::class.java, "TasksDb"  ).allowMainThreadQueries().build()
        }
    }


}