package com.example.schedule

class TextFormat {

    /**
     * 日付のフォーマット(例：2019/01/01)
     */
    fun  dateFormat(year: Int, month: Int, day: Int): String {
        val yearFormat = "%04d"
        val dayOrMonthFormat = "%02d"
        val y = yearFormat.format(year)
        val m = dayOrMonthFormat.format(month + 1)
        val d = dayOrMonthFormat.format(day)

        return "$y/$m/$d"
    }

    /**
     * TaskDateから受け取った日付のデータを
     * 指定のフォーマットに変換
     */
    fun taskDateFormat(taskDate: TaskDate): String {
        val year = taskDate.year
        val month = taskDate.month
        val day = taskDate.day

        return dateFormat(year, month, day)
    }



}