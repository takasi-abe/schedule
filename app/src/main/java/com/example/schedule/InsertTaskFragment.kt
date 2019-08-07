package com.example.schedule


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_insert_date.*
import kotlinx.android.synthetic.main.fragment_insert_task.*


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
        date.setOnClickListener {
            val fragment = InsertDateFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment)
                .commit()
        }
        button.setOnClickListener {
            dateLog()
        }
    }

    private fun dateLog() {
        val year = select_date.year
        val month = select_date.month
        val day = select_date.dayOfMonth
        Log.d("a", "$year/$month/$day")

    }
}
