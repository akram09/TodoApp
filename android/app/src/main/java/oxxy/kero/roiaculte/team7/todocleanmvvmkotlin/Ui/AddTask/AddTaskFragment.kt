package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks.TasksActivity
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseFragment
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.databinding.AddTasksFragmentBinding

class AddTaskFragment :BaseFragment(){
    lateinit var  binding :AddTasksFragmentBinding
    lateinit var  viewModel: AddTaskViewModel
    lateinit var callback: AddTaskCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory)[AddTaskViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        binding= DataBindingUtil.inflate(layoutInflater, R.layout.add_tasks_fragment ,container,false)
        callback =  viewModel
        binding.addTaskBtn.setOnClickListener {
           callback.onAddBtnClicked(binding.titleAddTask.text.toString()
               , binding.colorAddTask.text.toString(), binding.descriptionAddTask.text.toString())
        }

        viewModel.observe(this){
            when{
                it.taskAdded.peekContent()->{
                    startActivity(Intent((activity as AddTasksActivity),TasksActivity::class.java))
                }
            }
        }
        return binding.root
    }
    interface AddTaskCallback: BaseCallBack{
        fun onAddBtnClicked(title:String , color:String , description:String)
    }
}