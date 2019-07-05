package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.Ui.Tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import oxxy.kero.roiaculte.team7.domain.interactors.Tasks
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.R
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.base.BaseFragment
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.databinding.FragmentAlltasksBinding
import oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.Success

class TasksFragment :BaseFragment() {
    lateinit var  viewModel: TasksViewModel
    lateinit var adapter: TasksAdapter


    lateinit var  binding :FragmentAlltasksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory)[TasksViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_alltasks, container, false)
        viewModel.observe(this){
            handleStateChange(it)
        }
        binding.recyclerViewAlltasks.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        return binding.root
    }

    private fun handleStateChange(tasksState: TasksState) {

      when{
//          tasksState.tasks is Loading<Tasks> ->  /*show loading*/
         tasksState.tasks is Success<Tasks>->{
             adapter = TasksAdapter(
                 context = context!!,
                 tasks = tasksState.tasks()!!
             )
             binding.recyclerViewAlltasks.adapter= adapter
         }
//          tasksState.tasks is Fail->{
//              handleError
//          }
      }

    }
}