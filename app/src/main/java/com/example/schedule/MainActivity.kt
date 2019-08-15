package com.example.schedule

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = TabAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(pager)

//        insertTaskButton.setOnClickListener{
//
//            val fragment = InsertTaskFragment()
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//
//            fragmentTransaction.replace(R.id.pager, fragment)
//                .commit()
//        }
    }


}
