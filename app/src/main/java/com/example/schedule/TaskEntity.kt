package com.example.schedule

import com.squareup.moshi.Json

data class TaskEntity (
    @Json (name = "taskList")
    val taskList: TaskDetail
    )

data class TaskDetail (
    val task: String,
    val date: String
)