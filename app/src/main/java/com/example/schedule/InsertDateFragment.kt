package com.example.schedule


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_insert_date.*
import kotlinx.android.synthetic.main.fragment_insert_task.*

class InsertDateFragment : DialogFragment() {
    var date: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_date, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 選択した日付を取得
        dateSelected()

        // ボタン押下時に取得したデータを保存し、ダイアログを閉じる
        date_save.setOnClickListener {
            closeDialog()
        }

    }


    private fun dateSelected() {
        //カレンダーから選択された日付を取得
        val insertDay = select_date.dayOfMonth
        val insertMonth = select_date.month
        val insertYear = select_date.year

        date = "$insertYear/$insertMonth/$insertDay"



    }

    private fun closeDialog() {
//        // 取得した日付データをタスク入力画面で取得
//        val insertTaskFragment = InsertTaskFragment()
//        insertTaskFragment.getTaskDate(date)


        // ダイアログを閉じる
        this.dismiss()
    }
}
