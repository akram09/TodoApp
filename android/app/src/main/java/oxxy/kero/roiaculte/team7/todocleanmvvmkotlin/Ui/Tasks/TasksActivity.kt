package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask.AddTasksActivity
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseActivity
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseFragment
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.databinding.ActivityMainBinding
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.extension.inTransaction

class TasksActivity :BaseActivity() {
    lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportFragmentManager.inTransaction{
            add(R.id.frame_layout, fragment()).addToBackStack("addTaskFragment")
        }
        binding.fab.setOnClickListener{
            startActivity(Intent(this , AddTasksActivity::class.java))

        }

    }

    override fun fragment(): BaseFragment {
        return TasksFragment()
    }
}