package oxxy.kero.roiaculte.team7.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import oxxy.kero.roiaculte.team7.domain.domainModels.Task

@Entity(tableName = "tasks")
data class TaskEntity(
  @ColumnInfo(name = "TaskTitle") val title :String
                      ,@ColumnInfo(name="TaskDescription") val description:String
              , @ColumnInfo(name = "TaskColor")val color:String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long =0
}
fun map(task :Task):TaskEntity{
    return TaskEntity(task.title, task.description, task.color)
}
fun mapTo(taskEntity: TaskEntity):Task{
    return Task(taskEntity.id, taskEntity.title, taskEntity.description, taskEntity.color)
}