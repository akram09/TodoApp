package oxxy.kero.roiaculte.team7.data.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.domain.interactors.Tasks

@Dao
interface TasksDaos {

    @Query("SELECT *FROM TASKS")
    fun getTasks(): Flowable<List<TaskEntity>>
    @Insert
    fun addTask(task: TaskEntity)

}