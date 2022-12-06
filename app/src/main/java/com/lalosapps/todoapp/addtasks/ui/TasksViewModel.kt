package com.lalosapps.todoapp.addtasks.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor() : ViewModel() {

    var showDialog by mutableStateOf(false)
        private set

    fun onDialogHide() {
        showDialog = false
    }

    fun onDialogShow() {
        showDialog = true
    }

    fun onTaskCreated(task: String) {
        println(task)
        onDialogHide()
    }
}