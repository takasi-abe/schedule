package com.example.schedule

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(fm: FragmentManager, private val context: Context): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return TaskListFragment()
            }
            else -> {
                return InsertTaskFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when(position) {
            0 -> { return "予定一覧"}
            else -> { return "入力画面"}
        }
    }

    override fun getCount(): Int {
        return 2
    }
}