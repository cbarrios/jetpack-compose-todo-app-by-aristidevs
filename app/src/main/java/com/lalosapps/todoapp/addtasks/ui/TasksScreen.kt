package com.lalosapps.todoapp.addtasks.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.lalosapps.todoapp.addtasks.ui.components.AddTasksDialog
import com.lalosapps.todoapp.addtasks.ui.components.FabDialog

@Composable
fun TasksScreen(
    viewModel: TasksViewModel = hiltViewModel()
) {

    val isVisible = viewModel.showDialog
    Scaffold(
        floatingActionButton = {
            FabDialog(onClick = viewModel::onDialogShow)
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AddTasksDialog(
                visible = isVisible,
                onDismiss = viewModel::onDialogHide,
                onTaskAdded = viewModel::onTaskCreated
            )
        }
    }
}