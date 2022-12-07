package com.lalosapps.todoapp.addtasks.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lalosapps.todoapp.addtasks.domain.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor() : ViewModel() {

    var showDialog by mutableStateOf(false)
        private set

    private val _tasks = MutableStateFlow(emptyList<Task>())
    val tasks = _tasks.asStateFlow()

    fun onDialogHide() {
        showDialog = false
    }

    fun onDialogShow() {
        showDialog = true
    }

    fun onTaskCreated(task: String) {
        var list = _tasks.value
        list = list + Task(text = task)
        _tasks.update { list }
        onDialogHide()
    }

    fun onTaskCheckedChange(id: Long, checked: Boolean) {
        val list = _tasks.value
        val mapped = list.map { if (it.id == id) it.copy(checked = checked) else it }
        _tasks.update { mapped }
    }

    fun onTaskDeleted(id: Long) {
        val list = _tasks.value
        val filtered = list.filterNot { it.id == id }
        _tasks.update { filtered }
    }
}