package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import oxxy.kero.roiaculte.team7.domain.domainModels.Task
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import java.lang.IllegalArgumentException

class TasksAdapter(val context : Context, val tasks:List<Task>): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
       val v=    LayoutInflater.from(context).inflate(R.layout.task_viewholder, parent, false)
        return TaskViewHolder(v)
    }

    override fun getItemCount(): Int {
    return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.update(tasks[position])
    }

    inner class TaskViewHolder(view: View) :RecyclerView.ViewHolder(view){
           val  title = view.findViewById<TextView>(R.id.card_view_text_title)
            val description = view.findViewById<TextView>(R.id.cardview_text_description)
            val cardView = view.findViewById<CardView>(R.id.cardview)

        fun update(task:Task){
            title.text = task.title
            description.text = task.description
            if(task.color.isNotEmpty()) {
                try {


                    cardView.setCardBackgroundColor(Color.parseColor(task.color))
                }catch (e:IllegalArgumentException){
                    cardView.setCardBackgroundColor(Color.GREEN)
                }
            }
        }

    }
}