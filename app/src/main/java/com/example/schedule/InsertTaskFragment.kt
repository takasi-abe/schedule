package com.example.schedule


import android.app.DatePickerDialog
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_insert_task.*
import java.text.SimpleDateFormat
import java.util.*


class InsertTaskFragment : Fragment() {

    private val calendar = Calendar.getInstance()
    private var year = calendar.get(Calendar.YEAR)
    private var month = calendar.get(Calendar.MONTH)
    private var day = calendar.get(Calendar.DAY_OF_MONTH)
    private lateinit var  taskDate:TaskDate

    private var insertDate = ""
    private var selectGenre = ""

    private val adapter = Moshi.Builder().build().adapter(TaskEntity::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_task, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val df = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN)
        val toDay = Date()

        date.text = df.format(toDay)



    }


    override fun onStart() {
        super.onStart()

        // ジャンル指定
        getGenre()

        // 選択した日付を取得
        date.setOnClickListener {

            // 日付選択用のダイアログを指定
            val dtp = DatePickerDialog(activity as Context,DatePickerDialog.OnDateSetListener{_,y,m,d ->

                // 選択した日付をTaskDateに登録
                taskDate = TaskDate(y, m, d)

                // 選択した日付を指定のフォーマットに変換して保存
                insertDate = TextFormat().dateFormat(y, m, d)

                // 選択した日付をTextViewに表示
                date.text = insertDate

            }, year,month,day)

            // 指定したダイアログを表示
            dtp.show()
        }

        task_save.setOnClickListener {
            var taskId = 0
            val prefer: SharedPreferences = activity!!.getSharedPreferences("TaskList", MODE_PRIVATE)

            while (prefer.getString("$taskId",null) != null) {
                taskId += 1
            }

            val task = task.text.toString()
            val taskDetail = TaskDetail(task, taskDate, selectGenre)
            val taskEntity = TaskEntity(taskDetail)

            val jsonText = adapter.toJson(taskEntity)

            Log.d("taskDetail", "$taskDetail")
            prefer.edit().putString("$taskId", jsonText)
                .apply()

        }
    }

    private fun getGenre() {

        // genre用のspinnerのアダプターの作成
        val adapter = instanceSpinnerAdapter(R.array.genre)

        // spinnerのレイアウトを指定
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // アダプターをspinnerに適用
        genre.adapter

        // 選択肢を選択した際の処理
        genre.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener {

            // 選択した場合
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val  spinnerParent = parent as Spinner
                selectGenre = spinnerParent.selectedItem as String
                Log.d("select_genre", selectGenre)

            }

            // 選択しなかった場合
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun instanceSpinnerAdapter(arrayChoice: Int): ArrayAdapter<CharSequence>{

        return ArrayAdapter.createFromResource(
            activity as Context,
            arrayChoice,
            android.R.layout.simple_spinner_item
        )
    }
}
