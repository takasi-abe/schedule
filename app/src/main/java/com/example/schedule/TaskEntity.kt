package com.example.schedule

import com.squareup.moshi.Json

data class TaskEntity (
    @Json (name = "taskEntity")
    val taskDetail: TaskDetail
)

data class TaskDetail (
    @Json (name = "task")
    val task: String,

    @Json (name = "date")
    val taskDate: TaskDate,

    @Json (name = "genre")
    val taskGenre: String
)

data class TaskDate (
    val year: Int,
    val month: Int,
    val day: Int
)