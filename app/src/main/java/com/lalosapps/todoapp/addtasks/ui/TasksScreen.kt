package com.lalosapps.todoapp.addtasks.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.lalosapps.todoapp.addtasks.ui.components.AddTasksDialog
import com.lalosapps.todoapp.addtasks.ui.components.FabDialog

@Composable
fun TasksScreen(
    viewModel: TasksViewModel = hiltViewModel()
) {
    var isVisible by rememberSaveable { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FabDialog(onClick = { isVisible = true })
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AddTasksDialog(
                visible = isVisible,
                onDismiss = { isVisible = false },
                onTaskAdded = { isVisible = false }
            )
        }
    }
}