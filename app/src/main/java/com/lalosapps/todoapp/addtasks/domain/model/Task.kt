package com.lalosapps.todoapp.addtasks.domain.model

data class Task(
    val id: Long = System.currentTimeMillis(),
    val text: String,
    val checked: Boolean = false
)
