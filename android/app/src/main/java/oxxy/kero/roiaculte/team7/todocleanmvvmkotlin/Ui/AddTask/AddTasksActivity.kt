package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.AddTask

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.AndroidApplication
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseActivity
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseFragment
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.databinding.AddTasksActivityBinding
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.extension.inTransaction

class AddTasksActivity :BaseActivity() {

       lateinit var binding :AddTasksActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this , R.layout.add_tasks_activity)
        supportFragmentManager.inTransaction {
            add(R.id.frame_layout1, fragment())
        }

    }

    override fun fragment(): BaseFragment {
        return AddTaskFragment()
    }
}