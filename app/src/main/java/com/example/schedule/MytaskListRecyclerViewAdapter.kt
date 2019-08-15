package com.example.schedule

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_tasklist.view.*


class MytaskListRecyclerViewAdapter(
    private val mValues: ArrayList<TaskEntity>
) : RecyclerView.Adapter<MytaskListRecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_tasklist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position].taskDetail

        holder.dayView.text = TextFormat().taskDateFormat(item.taskDate)
        holder.jobView.text = item.task
        holder.genreView.text = item.taskGenre

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {

        val dayView: TextView = mView.date
        val jobView: TextView = mView.job
        val genreView: TextView = mView.genre

    }
}
