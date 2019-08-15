package com.example.schedule

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_insert_task.*
import kotlinx.android.synthetic.main.fragment_tasklist_list.view.*


class TaskListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasklist_list, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                val pref = activity!!.getSharedPreferences("TaskList", MODE_PRIVATE)
                val recyclerView = taskList
                val taskList = lodeTaskList(pref)
                val rvAdapter = MytaskListRecyclerViewAdapter(taskList)

                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(activity)
                recyclerView.adapter = rvAdapter

            }

        }

    }

    private fun lodeTaskList(pref: SharedPreferences): ArrayList<TaskEntity> {
        var unConvertTask: String? = pref.getString("1", null)
        var convertTask: TaskEntity?
        val convertTaskList: ArrayList<TaskEntity> = ArrayList()
        var taskId = 0
        val adapter = Moshi.Builder().build().adapter(TaskEntity::class.java)

        Log.d("aaa", "$unConvertTask")

        while (pref.getString("$taskId", null) != null) {
            unConvertTask = pref.getString("$taskId", null)

            Log.d("unConvert", "$unConvertTask")
            unConvertTask?.let {
                convertTask = adapter.fromJson(unConvertTask)

                convertTaskList.add(convertTask!!)
                Log.d("taskId_$taskId", "$convertTask")
                taskId += 1

            }

            convertTaskList.sortBy { taskEntity -> taskEntity.taskDetail.taskDate.day }
            convertTaskList.sortBy { taskEntity -> taskEntity.taskDetail.taskDate.month }
            convertTaskList.sortBy { taskEntity -> taskEntity.taskDetail.taskDate.year }

        }

        return convertTaskList
    }
}
