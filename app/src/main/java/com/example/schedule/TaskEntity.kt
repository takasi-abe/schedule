package com.example.schedule

import com.squareup.moshi.Json
import java.time.Year

data class TaskEntity (
    @Json (name = "taskList")
    val taskList: TaskDetail
    )

data class TaskDetail (
    val task: String,
    val day: Int,
    val month: Int,
    val year: Int

)