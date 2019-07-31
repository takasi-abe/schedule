package com.example.schedule


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import kotlinx.android.synthetic.main.fragment_insert_task.*
import java.text.SimpleDateFormat
import java.util.*


class InsertTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_task, container, false)
    }

    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            val date = calendarView.date
            Log.d("a", "$date")

            val format = SimpleDateFormat("yyyy/mm/dd")
            Log.d("b", "${format.format(date)}")
        }
    }
}